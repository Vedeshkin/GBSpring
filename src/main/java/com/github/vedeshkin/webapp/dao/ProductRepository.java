package com.github.vedeshkin.webapp.dao;

import com.github.vedeshkin.webapp.dto.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
@Repository
public class ProductRepository   {

    private List<Product> productList = new ArrayList<>();

    @PostConstruct
    private void init(){
        for(int i = 1; i <= 5; i++){
            productList.add(new Product(i,"Item_"+i, ThreadLocalRandom.current().nextDouble(1.00,100.00)));
        }
    }

    public Product getProductById(int id){
      return productList.stream().filter(s-> s.getId() == id).findAny().get();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
