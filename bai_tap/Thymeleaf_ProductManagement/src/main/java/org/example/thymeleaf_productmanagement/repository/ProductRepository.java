package org.example.thymeleaf_productmanagement.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.thymeleaf_productmanagement.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository implements  IProductRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        TypedQuery<Product> query = em.createQuery("from Product", Product.class);
        productList = query.getResultList();
        return productList;
    }

    @Transactional
    @Override
    public boolean add(Product product) {
        try {
            em.persist(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(int id, Product product) {
        try {
            Product productUpdate = findById(id);
            productUpdate.setProductName(product.getProductName());
            productUpdate.setProductDescription(product.getProductDescription());
            productUpdate.setProductPrice(product.getProductPrice());
            productUpdate.setProductCategory(product.getProductCategory());
            productUpdate.setProductQuantity(product.getProductQuantity());
            em.merge(productUpdate);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            Product productUpdate = findById(id);
            em.remove(productUpdate);
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Product findById(int id) {
        Product product = em.find(Product.class, id);
        return product;
    }

//    @Override
//    public List<Product> findByName(String name, Product product) {
//        List<Product> productListName = new ArrayList<>();
//        if (product.getProductName().equalsIgnoreCase(name)) {
//            productListName.add(product);
//        }
//        return productListName;
//    }
}
