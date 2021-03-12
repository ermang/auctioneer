package com.eg.auctioneer.service;

import com.eg.auctioneer.entity.ItemImage;
import com.eg.auctioneer.projection.ReadAuction;
import com.eg.auctioneer.repo.AuctionRepo;
import com.eg.auctioneer.repo.ItemImageRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AuctionQueryService {
    private final AuctionRepo auctionRepo;
    private final ItemImageRepo itemImageRepo;

    public AuctionQueryService(AuctionRepo auctionRepo, ItemImageRepo itemImageRepo) {
        this.auctionRepo = auctionRepo;
        this.itemImageRepo = itemImageRepo;
    }

    public ReadAuction readAuction(Long auctionId) {
        ReadAuction ra = auctionRepo.findByIdRO(auctionId);

        List<ItemImage> itemImageList =  itemImageRepo.findAllByItemId(ra.itemId);

        ra.itemImagePathList = new ArrayList<>();
        for(ItemImage ii: itemImageList)
            ra.itemImagePathList.add(ii.getImagePath());

        return ra;
    }
}
