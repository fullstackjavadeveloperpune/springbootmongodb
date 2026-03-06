package com.fullstack.service;

import com.fullstack.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product save(Product product);

    Optional<Product> findById(long productId);

    List<Product> findAll();

    Product update(long productId, Product product);

    Product changeProductPrice(long productId, double productPrice);

    void deleteById(long productId);

    void deleteAll();
}
