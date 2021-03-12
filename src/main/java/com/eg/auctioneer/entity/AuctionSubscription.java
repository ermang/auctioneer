package com.eg.auctioneer.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class AuctionSubscription extends BaseEntity{

    public enum Status {
        BIDDER,
        SPECTATOR
    }

    @NotNull
    @ManyToOne
    private AppUser appUser;

    @NotNull
    @ManyToOne
    private Auction auction;

    @Enumerated(EnumType.STRING)
    private Status status;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
