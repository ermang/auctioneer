package com.eg.auctioneer.service;

import com.eg.auctioneer.entity.AuctionImage;
import com.eg.auctioneer.projection.ReadAuction;
import com.eg.auctioneer.repo.AuctionRepo;
import com.eg.auctioneer.repo.AuctionImageRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AuctionQueryService {
    private final AuctionRepo auctionRepo;
    private final AuctionImageRepo auctionImageRepo;

    public AuctionQueryService(AuctionRepo auctionRepo, AuctionImageRepo auctionImageRepo) {
        this.auctionRepo = auctionRepo;
        this.auctionImageRepo = auctionImageRepo;
    }

    public ReadAuction readAuction(Long auctionId) {
        ReadAuction ra = auctionRepo.findByIdRO(auctionId);

        List<AuctionImage> auctionImageList =  auctionImageRepo.findAllByAuctionId(ra.id);

        ra.itemImagePathList = new ArrayList<>();
        for(AuctionImage ii: auctionImageList)
            ra.itemImagePathList.add(ii.getImagePath());

        return ra;
    }
}
