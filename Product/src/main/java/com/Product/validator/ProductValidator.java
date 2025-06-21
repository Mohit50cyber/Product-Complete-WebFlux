package com.Product.validator;

import com.Product.dto.ProductRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator {
    public void validate(ProductRequest productRequest){

        if(productRequest.getName() == null || productRequest.getName().isBlank()){
            throw new IllegalArgumentException("Name is required");
        }
        if(productRequest.getPrice()<=0){
            throw new IllegalArgumentException("Price must be positive");
        }

    }
}
