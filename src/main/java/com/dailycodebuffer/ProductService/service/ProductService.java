package com.dailycodebuffer.ProductService.service;

import com.dailycodebuffer.ProductService.model.ProductRequest;
import com.dailycodebuffer.ProductService.model.ProductResponce;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponce getProductById(long productId);

    void reduceQuantity(long prodcutId, long quantity);
}
