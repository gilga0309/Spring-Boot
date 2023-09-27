package com.example.product.data.handler.Impl;

import com.example.product.data.dao.ProductDAO;
import com.example.product.data.entity.ProductEntity;
import com.example.product.data.handler.ProductHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductHandlerImpl implements ProductHandler {

    private final ProductDAO productDAO;

    @Override
    public ProductEntity saveProduct(String productId, String productName, int productPrice, int productStock) {

        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);

        return productDAO.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    @Override
    public ProductEntity updateProduct(String productId, String productName, int productPrice, int productStock) {

        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);

        return productDAO.updateProduct(productEntity);
    }

    @Override
    public ProductEntity deleteProduct(String productId) {
        return productDAO.deleteProduct(productId);
    }
}
