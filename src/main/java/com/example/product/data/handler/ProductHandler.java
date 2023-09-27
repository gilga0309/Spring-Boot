package com.example.product.data.handler;
import com.example.product.data.entity.ProductEntity;

public interface ProductHandler {

    ProductEntity saveProduct(String productId, String productName, int productPrice, int productStock);
    ProductEntity getProduct(String productId);
    ProductEntity updateProduct(String productId, String productName, int productPrice, int productStock);
    ProductEntity deleteProduct(String productId);

}
