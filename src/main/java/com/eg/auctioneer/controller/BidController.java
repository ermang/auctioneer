package com.eg.auctioneer.controller;

import com.eg.auctioneer.dto.in.CreateBid;
import com.eg.auctioneer.service.BidCommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/bid")
public class BidController {

    private final BidCommandService bidCommandService;

    public BidController(BidCommandService bidCommandService) {
        this.bidCommandService = bidCommandService;
    }

    @PostMapping()
    public void createBid(@RequestBody @Valid CreateBid createBid){
        bidCommandService.createBid(createBid);
    }
}
