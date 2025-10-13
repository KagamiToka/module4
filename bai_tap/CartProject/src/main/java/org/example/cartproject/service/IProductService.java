package org.example.cartproject.service;

import org.example.cartproject.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
    boolean save(Product product);
}
