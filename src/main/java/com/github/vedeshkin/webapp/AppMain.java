package com.github.vedeshkin.webapp;

import com.github.vedeshkin.webapp.dao.Cart;
import com.github.vedeshkin.webapp.dao.ProductRepository;
import com.github.vedeshkin.webapp.exceptions.ItemNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.github.vedeshkin.webapp");
        ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");
        productRepository.getProductList().forEach(System.out::println);
        Cart cart1 = context.getBean(Cart.class);
        Cart cart2 = context.getBean(Cart.class);
        cart1.addItemToCard(productRepository.getProductById(1));
        cart1.addItemToCard(productRepository.getProductById(2));
        cart2.addItemToCard(productRepository.getProductById(2));
        cart2.addItemToCard(productRepository.getProductById(3));
        try {
            cart2.removeItemFromCardById(2);
        } catch (ItemNotFoundException e) {
            throw new RuntimeException(e);
        }
        cart2.getItemList().forEach(System.out::println);
        cart1.getItemList().forEach(System.out::println);


    }
}
