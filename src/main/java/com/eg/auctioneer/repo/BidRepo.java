package com.eg.auctioneer.repo;

import com.eg.auctioneer.entity.Bid;
import com.eg.auctioneer.projection.ReadBid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BidRepo extends JpaRepository<Bid, Long> {
//    @Query(value = "SELECT new com.eg.auctioneer.projection.ReadBid(b.id AS id, b.auction.id AS auctionId, b.amount AS amount)" +
//                   "   FROM Bid b" +
//                   "   WHERE b.auction.id = :auctionId" +
//                   "   ORDER BY b.amount DESC" +
//                   "   LIMIT 1")
//    ReadBid findByAuctionIdAndMaxAmountRO(@Param("auctionId") Long auctionId);

}
