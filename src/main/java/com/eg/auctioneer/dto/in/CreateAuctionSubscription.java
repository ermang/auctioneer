package com.eg.auctioneer.dto.in;

import com.eg.auctioneer.entity.AuctionSubscription;

public class CreateAuctionSubscription {
    public AuctionSubscription.SubscriptionStatus status;
    public Long auctionId;
}
