package com.eg.auctioneer.repo;

import com.eg.auctioneer.entity.Auction;
import com.eg.auctioneer.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepo extends JpaRepository<Auction, Long> {

}
