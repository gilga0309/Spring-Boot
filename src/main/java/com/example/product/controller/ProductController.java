package com.example.product.controller;

import com.example.product.data.dto.ProductDTO;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product-api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/product") //create
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {

        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    @GetMapping(value = "/product/{productId}") //read
    public ProductDTO getProduct(@PathVariable String productId) {
        return productService.getProduct(productId);
    }

    @PutMapping(value = "/product") //update
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {

        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        return productService.updateProduct(productId, productName, productPrice, productStock);
    }

    @DeleteMapping(value = "/product/{productId}") //delete
    public String deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return "Delete Success";
    }

}
