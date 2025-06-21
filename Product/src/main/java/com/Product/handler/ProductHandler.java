package com.Product.handler;

import com.Product.dto.ProductRequest;
import com.Product.mapper.ProductMapper;
import com.Product.service.ProductService;
import com.Product.validator.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductHandler {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ProductValidator productValidator;

    public Mono<ServerResponse> create(ServerRequest serverRequest){
        return serverRequest.bodyToMono(ProductRequest.class)
                .doOnNext(productValidator::validate)
                .map(productMapper::toEntity)
                .flatMap(productService::create)
                .map(productMapper::toResponse)
                .flatMap(productResponse -> ServerResponse.status(HttpStatus.CREATED).bodyValue(productResponse));
    }

    public Mono<ServerResponse> get(ServerRequest serverRequest){
        String id=serverRequest.pathVariable("id");
        return productService.get(id)
                .map(productMapper::toResponse)
                .flatMap(ServerResponse.ok()::bodyValue);
    }

    public Mono<ServerResponse> getAll(ServerRequest serverRequest){
        return productService.getAll()
                .map(productMapper::toResponse)
                .collectList()
                .flatMap(ServerResponse.ok()::bodyValue);
    }

    public Mono<ServerResponse> delete(ServerRequest serverRequest){
        String id= serverRequest.pathVariable("id");
        return productService.delete(id)
                .then(ServerResponse.noContent().build());
    }

}
