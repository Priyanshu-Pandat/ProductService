package com.dailycodebuffer.ProductService.repository;

import com.dailycodebuffer.ProductService.entity.Product;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<Product , Long> {
}
