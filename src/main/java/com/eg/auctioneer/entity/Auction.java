package com.eg.auctioneer.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Auction extends BaseEntity{

    @NotNull
    private String name;

    @NotNull
    @ManyToOne
    private Item item;

    @NotNull
    private BigDecimal startAmount;

    @NotNull
    private Boolean buyNowEnabled;

    private BigDecimal buyNowAmount;

    @NotNull
    private Boolean completed;

    @NotNull
    private LocalDateTime begin;

    @NotNull
    private LocalDateTime end;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(BigDecimal startAmount) {
        this.startAmount = startAmount;
    }

    public Boolean getBuyNowEnabled() {
        return buyNowEnabled;
    }

    public void setBuyNowEnabled(Boolean buyNowEnabled) {
        this.buyNowEnabled = buyNowEnabled;
    }

    public BigDecimal getBuyNowAmount() {
        return buyNowAmount;
    }

    public void setBuyNowAmount(BigDecimal buyNowAmount) {
        this.buyNowAmount = buyNowAmount;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
