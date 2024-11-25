package com.kshrd.setecwebapi.service;

import com.kshrd.setecwebapi.model.Product;
import com.kshrd.setecwebapi.model.ProductRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface ProductService {
    Object getAllProducts();

    Object getProductById(Long id, HttpServletResponse response);

    Object createProduct(ProductRequest productRequest, HttpServletResponse response);

    Object updateProduct(Long id, ProductRequest productRequest, HttpServletResponse response);

    Object deleteProduct(Long id, HttpServletResponse response);

    Object searchProductByName(String name, HttpServletResponse response);
}
