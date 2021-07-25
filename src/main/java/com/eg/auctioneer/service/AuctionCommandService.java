package com.eg.auctioneer.service;

import com.eg.auctioneer.dto.in.CreateAuction;
import com.eg.auctioneer.dto.in.CreateAuctionSubscription;
import com.eg.auctioneer.entity.Auction;
import com.eg.auctioneer.entity.AuctionSubscription;
import com.eg.auctioneer.projection.ReadAuction;
import com.eg.auctioneer.repo.AuctionRepo;
import com.eg.auctioneer.repo.AuctionSubscriptionRepo;
import com.eg.auctioneer.util.ActiveUserResolver;
import com.eg.auctioneer.util.Dto2Entity;
import org.quartz.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;

import static com.eg.auctioneer.util.Constant.AUCTION_BEGIN_END_MIN_REQUIRED_DURATION_AS_SECONDS;

@Transactional
@Service
public class AuctionCommandService {
    private final ActiveUserResolver activeUserResolver;
    private final Scheduler scheduler;
    private final Dto2Entity dto2Entity;
    private final AuctionRepo auctionRepo;
    private final AuctionSubscriptionRepo auctionSubscriptionRepo;

    public AuctionCommandService(ActiveUserResolver activeUserResolver, Scheduler scheduler, Dto2Entity dto2Entity, AuctionRepo auctionRepo,
                                 AuctionSubscriptionRepo auctionSubscriptionRepo) {
        this.activeUserResolver = activeUserResolver;
        this.scheduler = scheduler;
        this.dto2Entity = dto2Entity;
        this.auctionRepo = auctionRepo;
        this.auctionSubscriptionRepo = auctionSubscriptionRepo;
    }

    public void createAuction(CreateAuction createAuction) {

        if (createAuction.auctionBegin.isBefore(LocalDateTime.now()))
            throw new RuntimeException("auctionBegin can not be before now");

        if (createAuction.auctionEnd.isBefore(createAuction.auctionBegin))
            throw new RuntimeException("auctionEnd can not be before auctionBegin");

        if(Duration.between(createAuction.auctionBegin, createAuction.auctionEnd).getSeconds() < AUCTION_BEGIN_END_MIN_REQUIRED_DURATION_AS_SECONDS)
            throw new RuntimeException("There must be at least " + AUCTION_BEGIN_END_MIN_REQUIRED_DURATION_AS_SECONDS + " seconds between auctionBegin and auctionEnd");

        Auction auction = dto2Entity.createAuction2Auction(createAuction);

        auction = auctionRepo.save(auction);

        //quartz-stuff
        String jobBeginCron = auction.getBegin().getSecond()
                + " "
                + auction.getBegin().getMinute()
                + " "
                + auction.getBegin().getHour()
                + " "
                + auction.getBegin().getDayOfMonth()
                + " "
                + auction.getBegin().getMonth()
                + " "
                + "?"
                + " "
                + auction.getBegin().getYear();

        JobDataMap jobDataMap = new JobDataMap();
        //jobDataMap.put
       // Map

        JobDetail job = JobBuilder.newJob(SubscriptionJob.class)
                .withIdentity("subscription_" + auction.getId() + "_job", "group1")
                //.usingJobData("", auctionRepo)
                //.usingJobData("someProp", "someValue")
                .build();

        Trigger trigger= TriggerBuilder
                .newTrigger()
                .forJob(job)
                .withIdentity("subscription_" + auction.getId() + "_trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(jobBeginCron))
                .build();

        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
            throw new RuntimeException("schedule olmayi");
        }

        //quartz-stuff


    }

    public void subscribeAuction(CreateAuctionSubscription createAuctionSubscription) {
        ReadAuction ra = auctionRepo.findByIdRO(createAuctionSubscription.auctionId);

        if (ra == null)
            throw new RuntimeException("No such auction");

        if (ra.status == Auction.AuctionStatus.COMPLETED)
            throw new RuntimeException("Can not subscribe to a completed auction");

        if (ra.status == Auction.AuctionStatus.ACTIVE && createAuctionSubscription.status == AuctionSubscription.SubscriptionStatus.BIDDER)
            throw new RuntimeException("Active auctions can not be subscribed with BIDDER status");

        AuctionSubscription as = dto2Entity.createAuctionSubscription2AuctionSubscription(createAuctionSubscription);

        auctionSubscriptionRepo.save(as);
    }
}
