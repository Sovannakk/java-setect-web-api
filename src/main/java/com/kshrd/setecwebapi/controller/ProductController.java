package com.kshrd.setecwebapi.controller;

import com.kshrd.setecwebapi.model.ProductRequest;
import com.kshrd.setecwebapi.service.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Object getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Object getProductById(@PathVariable Long id, HttpServletResponse response) {
        return productService.getProductById(id, response);
    }

    @PostMapping
    public Object createProduct(@RequestBody ProductRequest productRequest, HttpServletResponse response) {
        return productService.createProduct(productRequest, response);
    }

    @PutMapping("/{id}")
    public Object updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest, HttpServletResponse response) {
        return productService.updateProduct(id, productRequest, response);
    }

    @DeleteMapping("/{id}")
    public Object deleteProduct(@PathVariable Long id, HttpServletResponse response) {
        return productService.deleteProduct(id, response);
    }

    @GetMapping("/search/{name}")
    public Object searchProductByName(@PathVariable String name, HttpServletResponse response) {
        return productService.searchProductByName(name, response);
    }

}
