package com.eg.auctioneer.repo;

import com.eg.auctioneer.entity.AuctionImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionImageRepo extends JpaRepository<AuctionImage, Long> {

    List<AuctionImage> findAllByAuctionId(Long auctionId);
}
