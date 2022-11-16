package com.github.vedeshkin.webapp.dao;

import com.github.vedeshkin.webapp.dto.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    @PostConstruct
    private void init() {
        for (int i = 1; i <= 5; i++) {
            productList.add(new Product("Item_" + i, ThreadLocalRandom.current().nextDouble(1.00, 100.00)));
        }
    }

    public Product getProductById(String id) {
        return productList.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }
}
