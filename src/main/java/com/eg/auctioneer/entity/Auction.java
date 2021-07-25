package com.eg.auctioneer.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Auction extends BaseEntity{

    public enum AuctionStatus {
        PENDING,
        ACTIVE,
        COMPLETED
    }

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    @ManyToOne
    private AppUser seller;

    @NotNull
    private BigDecimal startAmount;

    @NotNull
    private Boolean buyNowEnabled;

    private BigDecimal buyNowAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuctionStatus status;

    @NotNull
    private LocalDateTime begin;

    @NotNull
    private LocalDateTime end;

    @ManyToOne
    private AppUser winner;

    private BigDecimal winAmount;

    private Boolean winByBuyNow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppUser getSeller() {
        return seller;
    }

    public void setSeller(AppUser seller) {
        this.seller = seller;
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

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
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

    public AppUser getWinner() {
        return winner;
    }

    public void setWinner(AppUser winner) {
        this.winner = winner;
    }

    public BigDecimal getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(BigDecimal winAmount) {
        this.winAmount = winAmount;
    }

    public Boolean getWinByBuyNow() {
        return winByBuyNow;
    }

    public void setWinByBuyNow(Boolean winByBuyNow) {
        this.winByBuyNow = winByBuyNow;
    }
}
