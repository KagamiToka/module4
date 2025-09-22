package org.example.thymeleaf_productmanagement.repository;

import org.example.thymeleaf_productmanagement.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository implements  IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Sandwich", "Bánh mì theo phong cách Châu Âu", 20000, Arrays.asList("Bánh mì"), 20));
        productList.add(new Product(2, "Cá Kho Tộ", "Cá bông lau kho tộ", 40000, Arrays.asList("Hải Sản", "Cơm"), 20));
        productList.add(new Product(3, "Cơm Chiên Dương Châu", "Cơm chiên với hỗn hợp thành phần", 50000, Arrays.asList("Hải Sản", "Cơm"), 20));
        productList.add(new Product(4, "Lẩu", "Một loại bún nước", 80000, Arrays.asList("Bánh mì", "Hải Sản", "Mì-Bún"), 20));
        productList.add(new Product(5, "Bún chả", "Đặc sản Hà Lội-Việt Nam", 30000, Arrays.asList("Bánh mì", "Mì-Bún"), 20));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean add(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean update(int id, Product product) {
        if (product.getId() == id) {
            product.setId(id);
            product.setProductName(product.getProductName());
            product.setProductDescription(product.getProductDescription());
            product.setProductPrice(product.getProductPrice());
            product.setProductCategory(product.getProductCategory());
            product.setProductQuantity(product.getProductQuantity());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name, Product product) {
        List<Product> productListName = new ArrayList<>();
        if (product.getProductName().equalsIgnoreCase(name)) {
            productListName.add(product);
        }
        return productListName;
    }
}
