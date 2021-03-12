package com.eg.auctioneer.repo;

import com.eg.auctioneer.entity.AuctionSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionSubscriptionRepo extends JpaRepository<AuctionSubscription, Long> {

}
