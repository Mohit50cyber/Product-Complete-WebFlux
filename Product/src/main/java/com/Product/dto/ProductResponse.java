package com.Product.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private String id;
    private String name;
    private String description;
    private double price;
}
