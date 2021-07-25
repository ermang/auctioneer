package com.eg.auctioneer.repo;

import com.eg.auctioneer.entity.AuctionSubscription;
import com.eg.auctioneer.projection.ReadAuctionSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuctionSubscriptionRepo extends JpaRepository<AuctionSubscription, Long> {

    @Query("SELECT new com.eg.auctioneer.projection.ReadAuctionSubscription(a.id AS id, a.appUser.id AS appUserId, " +
            "a.auction.id AS auctionId, a.status AS status) FROM AuctionSubscription a " +
            "WHERE a.auction.id = :auctionId AND a.appUser.id = :appUserId")
    ReadAuctionSubscription findByAuctionIdAndAppUserIdRO(@Param("auctionId") Long auctionId, @Param("appUserId") Long appUserId);
}

