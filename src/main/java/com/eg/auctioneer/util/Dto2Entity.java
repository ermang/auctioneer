package com.eg.auctioneer.util;


import com.eg.auctioneer.dto.in.*;
import com.eg.auctioneer.entity.*;
import com.eg.auctioneer.repo.AppUserRepo;
import com.eg.auctioneer.repo.AuctionRepo;
import com.eg.auctioneer.repo.ItemRepo;
import org.springframework.stereotype.Service;

@Service
public class Dto2Entity {
    private final ActiveUserResolver activeUserResolver;
    private final AppUserRepo appUserRepo;
    private final ItemRepo itemRepo;
    private final AuctionRepo auctionRepo;

    public Dto2Entity(ActiveUserResolver activeUserResolver, AppUserRepo appUserRepo, ItemRepo itemRepo, AuctionRepo auctionRepo) {
        this.activeUserResolver = activeUserResolver;
        this.appUserRepo = appUserRepo;
        this.itemRepo = itemRepo;
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

    public Item createItem2Item(CreateItem createItem) {
        Item i = new Item();
        i.setName(createItem.name);
        i.setDescription(createItem.description);
        Long userId = activeUserResolver.getActiveUser().getUserId();
        i.setSeller(appUserRepo.getOne(userId));

        return i;
    }

    public Auction createAuction2Auction(CreateAuction createAuction) {
        Auction a = new Auction();
        a.setName(createAuction.name);
        a.setBegin(createAuction.auctionBegin);
        a.setEnd(createAuction.auctionEnd);
        a.setStartAmount(createAuction.startAmount);
        a.setItem(itemRepo.getOne(createAuction.itemId));
        a.setCompleted(false);

        if (createAuction.buyNowAmount == null) {
            a.setBuyNowEnabled(false);
            a.setBuyNowAmount(null);
        } else {
            a.setBuyNowEnabled(true);
            a.setBuyNowAmount(createAuction.buyNowAmount);
        }

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
