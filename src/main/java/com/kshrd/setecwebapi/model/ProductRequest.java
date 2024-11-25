package com.kshrd.setecwebapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;

    public Product toEntity() {
        return new Product(null, name, description, price, quantity);
    }

    public Product toEntity(Long id) {
        return new Product(id, name, description, price, quantity);
    }
}
