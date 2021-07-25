package com.eg.auctioneer.service;

import com.eg.auctioneer.dto.in.CreateBid;
import com.eg.auctioneer.entity.Auction;
import com.eg.auctioneer.entity.AuctionSubscription;
import com.eg.auctioneer.entity.Bid;
import com.eg.auctioneer.projection.ReadAuction;
import com.eg.auctioneer.projection.ReadAuctionSubscription;
import com.eg.auctioneer.projection.ReadBid;
import com.eg.auctioneer.repo.AuctionRepo;
import com.eg.auctioneer.repo.AuctionSubscriptionRepo;
import com.eg.auctioneer.repo.BidRepo;
import com.eg.auctioneer.util.ActiveUserResolver;
import com.eg.auctioneer.util.Dto2Entity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BidCommandService {
    private final ActiveUserResolver activeUserResolver;
    private final BidNotificationService bidNotificationService;
    private final Dto2Entity dto2Entity;
    private final BidRepo bidRepo;
    private final AuctionSubscriptionRepo auctionSubscriptionRepo;
    private final AuctionRepo auctionRepo;

    public BidCommandService(ActiveUserResolver activeUserResolver, BidNotificationService bidNotificationService,
                             Dto2Entity dto2Entity, BidRepo bidRepo, AuctionSubscriptionRepo auctionSubscriptionRepo, AuctionRepo auctionRepo) {
        this.activeUserResolver = activeUserResolver;
        this.bidNotificationService = bidNotificationService;
        this.dto2Entity = dto2Entity;
        this.bidRepo = bidRepo;
        this.auctionSubscriptionRepo = auctionSubscriptionRepo;
        this.auctionRepo = auctionRepo;
    }

    public void createBid(CreateBid createBid) {
        Bid b = dto2Entity.createBid2Bid(createBid);

        Long appUserId = activeUserResolver.getActiveUser().getUserId();
        ReadAuctionSubscription ras = auctionSubscriptionRepo.findByAuctionIdAndAppUserIdRO(createBid.auctionId, appUserId);
        ReadAuction ra = auctionRepo.findByIdRO(createBid.auctionId);
        //Bid rb = bidRepo.findByAuctionIdAndMaxAmountRO(createBid.auctionId);

        if(ras == null)
            throw new RuntimeException("User is not subscribed to this auction");

        if(ra.status != Auction.AuctionStatus.ACTIVE)
            throw new RuntimeException("Auction is not ACTIVE");

        //if(rb.amount != null && createBid.amount.compareTo)



        bidRepo.save(b);
        bidNotificationService.notifyNewBid(createBid.auctionId, createBid.amount);

    }
}
