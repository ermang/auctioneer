package com.eg.auctioneer.service;

import com.eg.auctioneer.dto.in.CreateAuction;
import com.eg.auctioneer.entity.Auction;
import com.eg.auctioneer.repo.AuctionRepo;
import com.eg.auctioneer.util.ActiveUserResolver;
import com.eg.auctioneer.util.Dto2Entity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AuctionCommandService {
    private final ActiveUserResolver activeUserResolver;
    private final Dto2Entity dto2Entity;
    private final AuctionRepo auctionRepo;

    public AuctionCommandService(ActiveUserResolver activeUserResolver, Dto2Entity dto2Entity, AuctionRepo auctionRepo) {
        this.activeUserResolver = activeUserResolver;
        this.dto2Entity = dto2Entity;
        this.auctionRepo = auctionRepo;
    }

    public void createAuction(CreateAuction createAuction) {
        Auction a = dto2Entity.createAuction2Auction(createAuction);

        auctionRepo.save(a);
    }
}
