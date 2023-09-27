package com.example.product.data.dao;

import com.example.product.data.entity.ProductEntity;

public interface ProductDAO {

    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity getProduct(String productId);
    ProductEntity updateProduct(ProductEntity productEntity);
    ProductEntity deleteProduct(String productId);

}
