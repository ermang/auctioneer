package com.eg.auctioneer.projection;

import com.eg.auctioneer.entity.Auction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReadBid {
    public Long id;
    public Long auctionId;
    public BigDecimal amount;


//    @Query(value = "SELECT new com.eg.auctioneer.projection.ReadAuction(a.id AS id, a.name AS name, a.description AS description" +
//            "    a.seller.id AS sellerId, a.seller.username AS username, a.startAmount AS startAmount," +
//            "   a.buyNowEnabled AS buyNowEnabled, a.buyNowAmount AS buyNowAmount, a.status AS status, a.begin AS begin," +
//            "   a.end AS end)" +
//            "   FROM Auction a" +
//            "   WHERE a.id = :auctionId")


    public ReadBid(Long id, Long auctionId, BigDecimal amount) {
        this.id = id;
        this.auctionId = auctionId;
        this.amount = amount;
    }
}
