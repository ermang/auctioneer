package com.eg.auctioneer.repo;

import com.eg.auctioneer.entity.Auction;
import com.eg.auctioneer.projection.ReadAuction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuctionRepo extends JpaRepository<Auction, Long> {

    @Query(value = "SELECT new com.eg.auctioneer.projection.ReadAuction(a.id AS id, a.name AS name, a.description AS description," +
            "   a.seller.id AS sellerId, a.seller.username AS username, a.startAmount AS startAmount," +
            "   a.buyNowEnabled AS buyNowEnabled, a.buyNowAmount AS buyNowAmount, a.status AS status, a.begin AS begin," +
            "   a.end AS end)" +
            "   FROM Auction a" +
            "   WHERE a.id = :auctionId")
    ReadAuction findByIdRO(@Param("auctionId") Long auctionId);
}

//
//    public ReadAuction(Long id, String name, BigDecimal startAmount, Boolean buyNowEnabled, BigDecimal buyNowAmount,
//                       Boolean completed, LocalDateTime begin, LocalDateTime end, Long itemId, String itemName, String itemDescription) {
//    private Long id;
//    private String name;
//    private BigDecimal startAmount;
//    private LocalDateTime begin;
//    private LocalDateTime end;
//    private Long itemId;
//    private String itemName;
//    private String itemDescription;

//    @NotNull
//    private String name;
//
//    @NotNull
//    private String description;
//
//    @NotNull
//    @ManyToOne
//    private AppUser seller;
//
//    @NotNull
//    private BigDecimal startAmount;
//
//    @NotNull
//    private Boolean buyNowEnabled;
//
//    private BigDecimal buyNowAmount;
//
//    @NotNull
//    @Enumerated(EnumType.STRING)
//    private Auction.AuctionStatus status;
//
//    @NotNull
//    private LocalDateTime begin;
//
//    @NotNull
//    private LocalDateTime end;
//
//    @ManyToOne
//    private AppUser winner;
//
//    private BigDecimal winAmount;
//
//    private Boolean winByBuyNow;