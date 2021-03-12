package com.eg.auctioneer.repo;

import com.eg.auctioneer.entity.ItemImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemImageRepo extends JpaRepository<ItemImage, Long> {

    List<ItemImage> findAllByItemId(Long itemId);
}
