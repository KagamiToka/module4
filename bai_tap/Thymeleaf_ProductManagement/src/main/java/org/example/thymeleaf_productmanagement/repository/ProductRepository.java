package org.example.thymeleaf_productmanagement.repository;

import jakarta.persistence.TypedQuery;
import org.example.thymeleaf_productmanagement.entity.Product;
import org.example.thymeleaf_productmanagement.utils.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository implements  IProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createQuery("from Product", Product.class);
        productList = query.getResultList();
        session.close();
        return productList;
    }

    @Override
    public boolean add(Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            session.persist(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(int id, Product product) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Product productUpdate = findById(id);
            productUpdate.setProductName(product.getProductName());
            productUpdate.setProductDescription(product.getProductDescription());
            productUpdate.setProductPrice(product.getProductPrice());
            productUpdate.setProductCategory(product.getProductCategory());
            productUpdate.setProductQuantity(product.getProductQuantity());
            session.merge(productUpdate);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            Product productUpdate = findById(id);
            session.remove(productUpdate);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public Product findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Product product = session.find(Product.class, id);
        session.close();
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
