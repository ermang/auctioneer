//package com.eg.auctioneer.controller;
//
//import com.eg.auctioneer.dto.in.CreateItem;
//import com.eg.auctioneer.service.ItemCommandService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/item")
//public class ItemController {
//
//    private final ItemCommandService itemCommandService;
//
//    public ItemController(ItemCommandService itemCommandService) {
//        this.itemCommandService = itemCommandService;
//    }
//
//    @PostMapping()
//    public void createItem(@RequestBody @Valid CreateItem createItem) throws IOException {
//        itemCommandService.createItem(createItem);
//    }
//}
