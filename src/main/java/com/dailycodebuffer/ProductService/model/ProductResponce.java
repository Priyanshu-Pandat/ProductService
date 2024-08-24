package com.dailycodebuffer.ProductService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponce {
    private String productName;
    private long productId;
    private long quantity;
    private long price;
}
