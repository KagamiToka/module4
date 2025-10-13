package org.example.cartproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product,Integer> entry : products.entrySet()) {
            if (entry.getKey().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product,Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product,Integer> entry : products.entrySet()) {
            if (entry.getKey().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product,1);
        } else {
            Map.Entry<Product,Integer> item = selectItemInCart(product);
            Integer newQuantity = item.getValue() + 1;
            products.replace(item.getKey(),newQuantity);
        }
    }

    public Integer countProductQuantity() {
        Integer quantity = 0;
        for (Map.Entry<Product,Integer> entry : products.entrySet()) {
            quantity += entry.getValue();
        }
        return quantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Double totalPrice() {
        double payment = 0.0;
        for (Map.Entry<Product,Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (double)entry.getValue();
        }
        return payment;
    }

}
