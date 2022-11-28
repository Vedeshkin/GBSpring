package com.github.vedeshkin.webapp.dao;

import com.github.vedeshkin.webapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductCostGreaterThan(Long cost);
    List<Product> findByProductCostLessThan(Long cost);
    List<Product> findByProductCostBetween(Long costMin, Long costMax);

}
