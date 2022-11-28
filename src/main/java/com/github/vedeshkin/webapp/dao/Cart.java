package com.github.vedeshkin.webapp.dao;

import com.github.vedeshkin.webapp.model.Product;
import com.github.vedeshkin.webapp.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {
    public List<Product> getItemList() {
        return itemList;
    }

    private final List<Product> itemList = new ArrayList<>();

    public void addItemToCard(Product product){
        System.out.println("Item added to cart " + product);
        itemList.add(product);
    }
    public void removeItemFromCardById(String id) throws ItemNotFoundException {
        boolean exists = itemList.stream().anyMatch(s-> s.getId().equals(id));
        if(!exists){
            throw new ItemNotFoundException();
        }
        Product p  = itemList.stream().filter(s -> s.getId().equals(id)).findFirst().get();
        itemList.remove(p);
        System.out.println("Item has been removed from cart: " +p);
    }

}
