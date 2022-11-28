package com.github.vedeshkin.webapp.controllers;

import com.github.vedeshkin.webapp.dao.ProductRepository;
import com.github.vedeshkin.webapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id){
        return repository.getReferenceById(id);
    }
    @GetMapping("/products")
    public List<Product> getProductList(@RequestParam Long min, @RequestParam Long max) {
        if(min != null && max != null){
            return  repository.findByProductCostBetween(min, max);
        }
        if(min != null){
            return repository.findByProductCostGreaterThan(min);
        }
        if(max != null){
            return repository.findByProductCostLessThan(max);
        }
        //Default
        return repository.findAll(Sort.by(Sort.Direction.ASC,"cost"));
    }

    @PostMapping("/products")
    public void createProduct(@RequestParam Product product){
        repository.save(product);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable Long id){
        repository.deleteById(id);
    }


}
