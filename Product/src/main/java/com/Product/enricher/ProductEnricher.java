package com.Product.enricher;

import java.util.UUID;

public class ProductEnricher {

    public static String generatedId(){
        return UUID.randomUUID().toString();
    }
}
