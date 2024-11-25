package com.kshrd.setecwebapi.service.impl;

import com.kshrd.setecwebapi.model.Product;
import com.kshrd.setecwebapi.model.ProductRequest;
import com.kshrd.setecwebapi.repository.ProductRepository;
import com.kshrd.setecwebapi.service.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Object getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Object getProductById(Long id, HttpServletResponse response) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            response.setStatus(HttpServletResponse.SC_OK);
            return product.get();
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return "Product " + id + " not found";
    }

    @Override
    public Object createProduct(ProductRequest productRequest, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_CREATED);
        return productRepository.save(productRequest.toEntity());
    }

    @Override
    public Object updateProduct(Long id, ProductRequest productRequest, HttpServletResponse response) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return productRepository.save(productRequest.toEntity(id));
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return "Product " + id + " not found";
    }

    @Override
    public Object deleteProduct(Long id, HttpServletResponse response) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            productRepository.delete(product.get());
            return "Product " + id + " successfully deleted";
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return "Product " + id + " not found";
    }

    @Override
    public Object searchProductByName(String name, HttpServletResponse response) {
        var products = productRepository.findAllByName(name);
        if (!products.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_OK);
            return products;
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return "Product " + name + " not found";
    }
}
