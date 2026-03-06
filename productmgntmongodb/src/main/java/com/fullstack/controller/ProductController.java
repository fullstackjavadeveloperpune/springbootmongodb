package com.fullstack.controller;

import com.fullstack.model.Product;
import com.fullstack.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final IProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        log.info("@@@@@@@@@@Trying to save data for Product:   " + product.getProductName());
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/findbyid/{productId}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable long productId) {
        return new ResponseEntity<>(productService.findById(productId), HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> update(@PathVariable long productId, @RequestBody Product product) {
        return new ResponseEntity<>(productService.update(productId, product), HttpStatus.CREATED);
    }

    @PatchMapping("/changeprice/{productId}/{productPrice}")
    public ResponseEntity<Product> changePrice(@PathVariable long productId, @PathVariable double productPrice) {
        return new ResponseEntity<>(productService.changeProductPrice(productId, productPrice), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid/{productId}")
    public ResponseEntity<Void> deleteById(@PathVariable long productId) {
        productService.deleteById(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll() {
        productService.deleteAll();
        return new ResponseEntity<>("All Data Deleted Successfully", HttpStatus.OK);
    }

}
