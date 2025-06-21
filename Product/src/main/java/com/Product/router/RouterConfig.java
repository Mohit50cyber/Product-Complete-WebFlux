package com.Product.router;

import com.Product.handler.ProductHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    public RouterFunction<ServerResponse> productRoutes(ProductHandler productHandler){
        return RouterFunctions.route()
                .POST("/products",productHandler::create)
                .GET("/products",productHandler::getAll)
                .GET("/products/{id}",productHandler::get)
                .DELETE("/products/{id}",productHandler::delete)
                .build();
    }
}
