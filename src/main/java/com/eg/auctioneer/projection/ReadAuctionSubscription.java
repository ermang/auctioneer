package com.eg.auctioneer.projection;

import com.eg.auctioneer.entity.AuctionSubscription;

public class ReadAuctionSubscription {
    public Long id;
    public Long appUserId;
    public Long auctionId;
    public AuctionSubscription.SubscriptionStatus status;

    public ReadAuctionSubscription(Long id, Long appUserId, Long auctionId, AuctionSubscription.SubscriptionStatus status) {
        this.id = id;
        this.appUserId = appUserId;
        this.auctionId = auctionId;
        this.status = status;
    }
}
