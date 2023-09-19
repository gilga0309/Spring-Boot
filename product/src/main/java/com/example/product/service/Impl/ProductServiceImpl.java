package com.example.product.service.Impl;

import com.example.product.data.dto.ProductDTO;
import com.example.product.data.entity.ProductEntity;
import com.example.product.data.handler.ProductHandler;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Service
@RequiredArgsConstructor
@ControllerAdvice
public class ProductServiceImpl implements ProductService {

    private final ProductHandler productHandler;

    @Override
    public ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productHandler.saveProduct(productId,productName,productPrice,productStock);

        ProductDTO productDTO = new ProductDTO(productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getProductStock());

        return productDTO;
    }

    @Override
    public ProductDTO getProduct(String productId) {
        ProductEntity productEntity = productHandler.getProduct(productId);

        ProductDTO productDTO = new ProductDTO(productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getProductStock());
        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(String productId, String productName, int productPrice, int productStock) {

        ProductEntity productEntity = productHandler.updateProduct(productId,productName,productPrice,productStock);

        ProductDTO productDTO = new ProductDTO(productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getProductStock());
        return productDTO;
    }

    @Override
    public ProductDTO deleteProduct(String productId) {

        ProductEntity productEntity = productHandler.getProduct(productId);

        ProductDTO productDTO = new ProductDTO(productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getProductStock());

        productHandler.deleteProduct(productId);

        return productDTO;
    }
}
