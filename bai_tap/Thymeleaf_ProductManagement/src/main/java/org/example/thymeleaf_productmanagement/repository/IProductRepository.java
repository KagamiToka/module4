package org.example.thymeleaf_productmanagement.repository;

import org.example.thymeleaf_productmanagement.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean add(Product product);
    boolean update(int id, Product product);
    boolean delete(int id);
    Product findById(int id);
    List<Product> findByName(String name, Product product);
}
