package com.dailycodebuffer.ProductService.controller;

import com.dailycodebuffer.ProductService.model.ProductRequest;
import com.dailycodebuffer.ProductService.model.ProductResponce;
import com.dailycodebuffer.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class Controller {
    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {

      long productId = productService.addProduct(productRequest);
      return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponce> getProductById( @PathVariable("id") long productId) {
        ProductResponce productResponce
                = productService.getProductById(productId);
        return new ResponseEntity<>(productResponce, HttpStatus.OK);
    }

    @PutMapping("reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(
       @PathVariable("id") long productId ,
       @RequestParam() long quantity) {
        productService.reduceQuantity(productId , quantity);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    }

