package com.eg.auctioneer.controller;

import com.eg.auctioneer.dto.in.CreateAuction;
import com.eg.auctioneer.dto.in.CreateAuctionSubscription;
import com.eg.auctioneer.projection.ReadAuction;
import com.eg.auctioneer.service.AuctionCommandService;
import com.eg.auctioneer.service.AuctionQueryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    private final AuctionCommandService auctionCommandService;
    private final AuctionQueryService auctionQueryService;

    public AuctionController(AuctionCommandService auctionCommandService, AuctionQueryService auctionQueryService) {
        this.auctionCommandService = auctionCommandService;
        this.auctionQueryService = auctionQueryService;
    }

    @PostMapping()
    public void createAuction(@RequestBody @Valid CreateAuction createAuction){
        auctionCommandService.createAuction(createAuction);
    }

    @PostMapping("/subscribe")
    public void subscribeAuction(@RequestBody @Valid CreateAuctionSubscription createAuctionSubscription){
        auctionCommandService.subscribeAuction(createAuctionSubscription);
    }

    @GetMapping("/{auctionId}")
    public ReadAuction readAuction(@PathVariable long auctionId){
        ReadAuction readAuction = auctionQueryService.readAuction(auctionId);

        return readAuction;
    }

}
