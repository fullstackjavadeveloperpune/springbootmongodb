package com.fullstack.service;

import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.model.Product;
import com.fullstack.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;


    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(long productId) {
        return Optional.of(productRepository.findById(productId).orElseThrow(() -> new RecordNotFoundException("Product #ID Does Not Exist")));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(long productId, Product product) {

        Product product1 = findById(productId).get();
        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        product1.setProductDescription(product.getProductDescription());
        product1.setProductLaunchDate(product.getProductLaunchDate());

        return productRepository.save(product1);
    }

    @Override
    public Product changeProductPrice(long productId, double productPrice) {
        Product product = findById(productId).get();
        product.setProductPrice(productPrice);

        return productRepository.save(product);
    }

    @Override
    public void deleteById(long productId) {

        productRepository.deleteById(productId);
    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
