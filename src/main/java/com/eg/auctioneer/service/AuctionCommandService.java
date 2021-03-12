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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Transactional
@Service
public class AuctionCommandService {
    private final ActiveUserResolver activeUserResolver;
    private final Dto2Entity dto2Entity;
    private final AuctionRepo auctionRepo;
    private final AuctionSubscriptionRepo auctionSubscriptionRepo;

    public AuctionCommandService(ActiveUserResolver activeUserResolver, Dto2Entity dto2Entity, AuctionRepo auctionRepo,
                                 AuctionSubscriptionRepo auctionSubscriptionRepo) {
        this.activeUserResolver = activeUserResolver;
        this.dto2Entity = dto2Entity;
        this.auctionRepo = auctionRepo;
        this.auctionSubscriptionRepo = auctionSubscriptionRepo;
    }

    public void createAuction(CreateAuction createAuction) {

        if (createAuction.auctionBegin.isBefore(LocalDateTime.now()))
            throw new RuntimeException("auctionBegin can not be before now");

        if (createAuction.auctionEnd.isBefore(createAuction.auctionBegin))
            throw new RuntimeException("auctionEnd can not be before auctionBegin");

        Auction a = dto2Entity.createAuction2Auction(createAuction);

        auctionRepo.save(a);
    }

    public void subscribeAuction(CreateAuctionSubscription createAuctionSubscription) {
        ReadAuction ra = auctionRepo.findByIdRO(createAuctionSubscription.auctionId);

        if (ra.completed == false && ra.begin.isAfter(LocalDateTime.now()) && createAuctionSubscription.status == AuctionSubscription.Status.BIDDER)
            throw new RuntimeException("Auction has already begun, subscribe as BIDDER is forbidden");

        AuctionSubscription csa = dto2Entity.createAuctionSubscription2AuctionSubscription(createAuctionSubscription);

        auctionSubscriptionRepo.save(csa);
    }
}
