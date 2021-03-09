package com.eg.auctioneer.repo;

import com.eg.auctioneer.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepo extends JpaRepository<Bid, Long> {

}
