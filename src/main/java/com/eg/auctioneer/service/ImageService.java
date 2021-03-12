package com.eg.auctioneer.service;

import com.eg.auctioneer.dto.in.CreateItem;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ImageService {

    public List<String> createProductImages(CreateItem createItem, Long itemId) throws IOException {
        List<String> imagePathList = new ArrayList<>();

        List<byte[]> decodedImages = new ArrayList<>();
        for(String encodedImg : createItem.base64EncodedImages)
            decodedImages.add(Base64.getDecoder().decode(encodedImg));

        String rootImageFolderName= "auctioneerImage";
        File rootImageFolder = new File(rootImageFolderName);
        if (!rootImageFolder.exists())
            Files.createDirectory(Paths.get(rootImageFolderName));

        String itemImageFolderName = rootImageFolderName + "/" + itemId;
        File productImageFolder = new File(itemImageFolderName);
        if (!productImageFolder.exists())
            Files.createDirectory(Paths.get(itemImageFolderName));

        for(int i=0;i<decodedImages.size();i++) {
            String imageName = itemImageFolderName + "/" + i + ".jpg";
            File imageFile = new File(imageName);
            if(!imageFile.exists())
                try (FileOutputStream fos = new FileOutputStream(imageName)) {
                    fos.write(decodedImages.get(i));
                }

            imagePathList.add(imageName);
        }

        return imagePathList;
    }

//    public List<String> generateProductImagePaths(CreateProduct cp, Long productId) {
//        List<String> imagePaths = new ArrayList<>();
//        for(int i=0;i<cp.base64Images.size();i++)
//            imagePaths.add("eclothingImage" + "/" + productId + "/" + i + ".jpg");
//
//        return imagePaths;
//    }
}
