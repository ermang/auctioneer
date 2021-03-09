package com.eg.auctioneer.service;

import com.eg.auctioneer.dto.in.CreateBid;
import com.eg.auctioneer.entity.Bid;
import com.eg.auctioneer.repo.BidRepo;
import com.eg.auctioneer.util.ActiveUserResolver;
import com.eg.auctioneer.util.Dto2Entity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BidCommandService {
    private final ActiveUserResolver activeUserResolver;
    private final Dto2Entity dto2Entity;
    private final BidRepo bidRepo;

    public BidCommandService(ActiveUserResolver activeUserResolver, Dto2Entity dto2Entity, BidRepo bidRepo) {
        this.activeUserResolver = activeUserResolver;
        this.dto2Entity = dto2Entity;
        this.bidRepo = bidRepo;
    }

    public void createBid(CreateBid createBid) {
        Bid b = dto2Entity.createBid2Bid(createBid);

        bidRepo.save(b);
    }
}
