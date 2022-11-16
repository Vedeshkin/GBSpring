package com.github.vedeshkin.webapp.controllers;

import com.github.vedeshkin.webapp.dao.ProductRepository;
import com.github.vedeshkin.webapp.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("/product-list")
    public String listOfProducts(Model model){
        model.addAttribute("productList",repository.getProductList());
        return "productList";
    }
    @PostMapping("/product")
    public String addNewProduct(@RequestParam("pname") String productName,
                              @RequestParam("pcost") String productCost) {
        double cost = Double.parseDouble(productCost);
        Product newProduct =  new Product(productName, cost);
        repository.addProduct(newProduct);
        return "redirect:/product-list";
    }
}
