package com.Product.mapper;

import com.Product.dto.ProductRequest;
import com.Product.dto.ProductResponse;
import com.Product.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductRequest productRequest);
    ProductResponse toResponse(Product product);
}
