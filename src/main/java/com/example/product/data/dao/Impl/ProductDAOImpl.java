package com.example.product.data.dao.Impl;

import com.example.product.data.dao.ProductDAO;
import com.example.product.data.entity.ProductEntity;
import com.example.product.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {

        ProductEntity productEntity1 = productRepository.getById(productEntity.getProductId());

        productEntity1.setProductName(productEntity.getProductName());
        productEntity1.setProductPrice(productEntity.getProductPrice());
        productEntity1.setProductStock(productEntity.getProductStock());

        return productEntity1;
    }

    @Override
    public ProductEntity deleteProduct(String productId) {
        productRepository.deleteById(productId);
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }
}
