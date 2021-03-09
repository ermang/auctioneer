package com.eg.auctioneer.util;


import com.eg.auctioneer.dto.in.CreateAuction;
import com.eg.auctioneer.dto.in.CreateBid;
import com.eg.auctioneer.dto.in.CreateItem;
import com.eg.auctioneer.dto.in.CreateUser;
import com.eg.auctioneer.entity.AppUser;
import com.eg.auctioneer.entity.Auction;
import com.eg.auctioneer.entity.Bid;
import com.eg.auctioneer.entity.Item;
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
        a.setBegin(createAuction.begin);
        a.setEnd(createAuction.end);
        a.setStartAmount(createAuction.startAmount);
        a.setItem(itemRepo.getOne(createAuction.itemId));

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
//
//    public Thread createThread2Thread(CreateThread createThread) {
//        Thread t  = new Thread();
//        t.setContent(createThread.content);
//        t.setTopic(topicRepo.getOne(createThread.topicId));
//        t.setCreatedOn(LocalDateTime.now());
//        Long userId = activeUserResolver.getActiveUser().getUserId();
//        t.setAppUser(appUserRepo.getOne(userId));
//
//        return t;
//    }
}
