package com.Product.wrapper;

import com.Product.dto.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestWrapper {
    private ProductRequest productRequest;
}
