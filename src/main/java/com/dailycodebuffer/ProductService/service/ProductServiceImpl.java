package com.dailycodebuffer.ProductService.service;

import com.dailycodebuffer.ProductService.entity.Product;
import com.dailycodebuffer.ProductService.exception.ProductServiceCustomException;
import com.dailycodebuffer.ProductService.model.ProductRequest;
import com.dailycodebuffer.ProductService.model.ProductResponce;
import com.dailycodebuffer.ProductService.repository.ProductRepository;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
@Builder
public class ProductServiceImpl implements ProductService{
    @Autowired
private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding product :{} " , productRequest);
        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

        productRepository.save(product);
        log.info("Product added successfully : {} " , product);
        return product.getProductId();
    }

    @Override
    public ProductResponce getProductById(long productId) {
        log.info("Getting product by id:{} " , productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("Product not found for this id" , "PRODUCT_NOT_FOUND"));
        ProductResponce productResponce
                = new ProductResponce();
        copyProperties(product, productResponce);
        return productResponce;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reducing quantity{} for Id{}", quantity , productId);
        Product product
                = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException(
                        "Product for given Id not Found" ,
                        "PRODUCT_NOT_FOUND"
                ));
        if(product.getQuantity() < quantity) {
            throw new ProductServiceCustomException(
                    "Not enough quantity available for this product" ,
                    "NOT_ENOUGH_QUANTITY"
            );
        }
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Quantity reduced successfully for product : {}"  , product);

    }
}
