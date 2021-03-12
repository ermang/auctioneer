package com.eg.auctioneer.dto.in;

import com.eg.auctioneer.entity.AuctionSubscription;

public class CreateAuctionSubscription {
    public AuctionSubscription.Status status;
    public Long auctionId;
}
