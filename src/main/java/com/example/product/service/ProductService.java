package com.example.product.service;

import com.example.product.data.dto.ProductDTO;

public interface ProductService {

    ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock);
    ProductDTO getProduct(String productId);
    ProductDTO updateProduct(String productId, String productName, int productPrice, int productStock);
    ProductDTO deleteProduct(String productId);

}
