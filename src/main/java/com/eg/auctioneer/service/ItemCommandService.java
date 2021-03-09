package com.eg.auctioneer.service;

import com.eg.auctioneer.dto.in.CreateItem;
import com.eg.auctioneer.entity.Item;
import com.eg.auctioneer.repo.ItemRepo;
import com.eg.auctioneer.util.ActiveUserResolver;
import com.eg.auctioneer.util.Dto2Entity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Transactional
@Service
public class ItemCommandService {
    private final ActiveUserResolver activeUserResolver;
    private final Dto2Entity dto2Entity;
    private final ItemRepo itemRepo;

    public ItemCommandService(ActiveUserResolver activeUserResolver, Dto2Entity dto2Entity, ItemRepo itemRepo) {
        this.activeUserResolver = activeUserResolver;
        this.dto2Entity = dto2Entity;
        this.itemRepo = itemRepo;
    }

    public void createItem(CreateItem createItem) {
        Item i =  dto2Entity.createItem2Item(createItem);

        itemRepo.save(i);
    }
}
