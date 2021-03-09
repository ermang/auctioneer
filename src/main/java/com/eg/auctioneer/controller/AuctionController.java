package com.eg.auctioneer.controller;

import com.eg.auctioneer.dto.in.CreateAuction;
import com.eg.auctioneer.service.AuctionCommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    private final AuctionCommandService auctionCommandService;

    public AuctionController(AuctionCommandService auctionCommandService) {
        this.auctionCommandService = auctionCommandService;
    }

    @PostMapping()
    public void createAuction(@RequestBody @Valid CreateAuction createAuction){
        auctionCommandService.createAuction(createAuction);
    }
}
