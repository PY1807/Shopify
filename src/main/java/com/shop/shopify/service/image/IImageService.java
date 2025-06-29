package com.shop.shopify.service.image;

import com.shop.shopify.dto.ImageDto;
import com.shop.shopify.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);

    void deleteImageById(Long id);

    List<ImageDto> saveImages(Long productId, List<MultipartFile> files);

    void updateImage(MultipartFile file, Long imageId);
}
