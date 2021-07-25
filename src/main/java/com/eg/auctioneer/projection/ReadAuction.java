package com.eg.auctioneer.projection;

import com.eg.auctioneer.entity.Auction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReadAuction {
    public Long id;
    public String name;
    public String description;
    public Long sellerId;
    public String sellerUsername;
    public BigDecimal startAmount;
    public Boolean buyNowEnabled;
    public BigDecimal buyNowAmount;
    public Auction.AuctionStatus status;
    public LocalDateTime begin;
    public LocalDateTime end;

    public List<String> itemImagePathList;

//    @Query(value = "SELECT new com.eg.auctioneer.projection.ReadAuction(a.id AS id, a.name AS name, a.description AS description" +
//            "    a.seller.id AS sellerId, a.seller.username AS username, a.startAmount AS startAmount," +
//            "   a.buyNowEnabled AS buyNowEnabled, a.buyNowAmount AS buyNowAmount, a.status AS status, a.begin AS begin," +
//            "   a.end AS end)" +
//            "   FROM Auction a" +
//            "   WHERE a.id = :auctionId")


    public ReadAuction(Long id, String name, String description, Long sellerId, String sellerUsername, BigDecimal startAmount,
                       Boolean buyNowEnabled, BigDecimal buyNowAmount, Auction.AuctionStatus status, LocalDateTime begin, LocalDateTime end) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sellerId = sellerId;
        this.sellerUsername = sellerUsername;
        this.startAmount = startAmount;
        this.buyNowEnabled = buyNowEnabled;
        this.buyNowAmount = buyNowAmount;
        this.status = status;
        this.begin = begin;
        this.end = end;
    }
}
