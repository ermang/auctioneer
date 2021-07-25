//package com.eg.auctioneer.service;
//
//import com.eg.auctioneer.dto.in.CreateItem;
//import com.eg.auctioneer.entity.Item;
//import com.eg.auctioneer.entity.ItemImage;
//import com.eg.auctioneer.repo.ItemImageRepo;
//import com.eg.auctioneer.repo.ItemRepo;
//import com.eg.auctioneer.util.ActiveUserResolver;
//import com.eg.auctioneer.util.Dto2Entity;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.validation.Valid;
//import java.io.IOException;
//import java.util.List;
//
//@Transactional
//@Service
//public class ItemCommandService {
//    private final ActiveUserResolver activeUserResolver;
//    private final ImageService imageService;
//    private final Dto2Entity dto2Entity;
//    private final ItemRepo itemRepo;
//    private final ItemImageRepo itemImageRepo;
//
//    public ItemCommandService(ActiveUserResolver activeUserResolver, ImageService imageService, Dto2Entity dto2Entity,
//                              ItemRepo itemRepo, ItemImageRepo itemImageRepo) {
//        this.activeUserResolver = activeUserResolver;
//        this.imageService = imageService;
//        this.dto2Entity = dto2Entity;
//        this.itemRepo = itemRepo;
//        this.itemImageRepo = itemImageRepo;
//    }
//
//    public void createItem(CreateItem createItem) throws IOException {
//        Item i =  dto2Entity.createItem2Item(createItem);
//
//        i = itemRepo.save(i);
//
//        List<String> imagePaths = imageService.createProductImages(createItem, i.getId());
//
//        for(String s : imagePaths) {
//            ItemImage ii = new ItemImage();
//            ii.setItem(i);
//            ii.setImagePath(s);
//            itemImageRepo.save(ii);
//        }
//
//        //itemImageRepo.saveAll()
//
//    }
//}
