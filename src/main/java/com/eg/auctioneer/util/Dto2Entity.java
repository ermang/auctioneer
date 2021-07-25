package com.eg.auctioneer.util;


import com.eg.auctioneer.dto.in.*;
import com.eg.auctioneer.entity.*;
import com.eg.auctioneer.repo.AppUserRepo;
import com.eg.auctioneer.repo.AuctionRepo;
import org.springframework.stereotype.Service;

@Service
public class Dto2Entity {
    private final ActiveUserResolver activeUserResolver;
    private final AppUserRepo appUserRepo;
    private final AuctionRepo auctionRepo;

    public Dto2Entity(ActiveUserResolver activeUserResolver, AppUserRepo appUserRepo, AuctionRepo auctionRepo) {
        this.activeUserResolver = activeUserResolver;
        this.appUserRepo = appUserRepo;
        this.auctionRepo = auctionRepo;
    }

    public AppUser createUser2AppUser(CreateUser createUser) {
        AppUser u = new AppUser();
        u.setUsername(createUser.username);
        u.setPassword(createUser.password);
        u.setRole(Constant.ROLE_USER);
        u.setEnabled(true);

        return u;
    }

//    public Item createItem2Item(CreateItem createItem) {
//        Item i = new Item();
//        i.setName(createItem.name);
//        i.setDescription(createItem.description);
//        Long userId = activeUserResolver.getActiveUser().getUserId();
//        i.setSeller(appUserRepo.getOne(userId));
//
//        return i;
//    }

    public Auction createAuction2Auction(CreateAuction createAuction) {
        Auction a = new Auction();
        a.setName(createAuction.name);
        a.setDescription(createAuction.description);
        Long userId = activeUserResolver.getActiveUser().getUserId();
        a.setSeller(appUserRepo.getOne(userId));
        a.setStartAmount(createAuction.startAmount);

        if (createAuction.buyNowEnabled == false) {
            a.setBuyNowEnabled(false);
            a.setBuyNowAmount(null);
        } else {
            a.setBuyNowEnabled(true);
            a.setBuyNowAmount(createAuction.buyNowAmount);
        }

        a.setStatus(Auction.AuctionStatus.PENDING);
        a.setBegin(createAuction.auctionBegin);
        a.setEnd(createAuction.auctionEnd);

        return a;
    }

    public Bid createBid2Bid(CreateBid createBid) {
        Bid b = new Bid();
        b.setAmount(createBid.amount);
        b.setAuction(auctionRepo.getOne(createBid.auctionId));
        Long userId = activeUserResolver.getActiveUser().getUserId();
        b.setAppUser(appUserRepo.getOne(userId));

        return b;
    }

    public AuctionSubscription createAuctionSubscription2AuctionSubscription(CreateAuctionSubscription createAuctionSubscription) {
        AuctionSubscription as = new AuctionSubscription();
        as.setAuction(auctionRepo.getOne(createAuctionSubscription.auctionId));
        as.setStatus(createAuctionSubscription.status);
        Long userId = activeUserResolver.getActiveUser().getUserId();
        as.setAppUser(appUserRepo.getOne(userId));

        return as;
    }
}
