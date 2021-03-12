package com.eg.auctioneer.projection;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReadAuction {
    public Long id;
    public String name;
    public BigDecimal startAmount;
    public Boolean buyNowEnabled;
    public BigDecimal buyNowAmount;
    public Boolean completed;
    public LocalDateTime begin;
    public LocalDateTime end;
    public Long itemId;
    public String itemName;
    public String itemDescription;
    public List<String> itemImagePathList;

    public ReadAuction(Long id, String name, BigDecimal startAmount, Boolean buyNowEnabled, BigDecimal buyNowAmount,
                       Boolean completed, LocalDateTime begin, LocalDateTime end, Long itemId, String itemName, String itemDescription
                ) {
        this.id = id;
        this.name = name;
        this.startAmount = startAmount;
        this.buyNowEnabled = buyNowEnabled;
        this.buyNowAmount = buyNowAmount;
        this.completed = completed;
        this.begin = begin;
        this.end = end;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }
}
