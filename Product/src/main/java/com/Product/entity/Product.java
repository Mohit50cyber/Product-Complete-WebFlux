package com.Product.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
@Builder
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private double price;
}
