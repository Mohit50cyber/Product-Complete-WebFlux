package com.Product.service;

import com.Product.entity.Product;
import com.Product.exception.ProductNotFoundException;
import com.Product.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public Mono<Product> create(Product product){
        return productRepo.save(product);
    }

    public Mono<Product> get(String id){
        return productRepo.findById(id)
                .switchIfEmpty(Mono.error(new ProductNotFoundException("Product not found")));
    }

    public Flux<Product> getAll(){
        return productRepo.findAll();
    }

    public Mono<Void> delete(String id){
        return productRepo.findById(id)
                .switchIfEmpty(Mono.error(new ProductNotFoundException("Product Not found")))
                .flatMap(productRepo::delete);
    }
}
