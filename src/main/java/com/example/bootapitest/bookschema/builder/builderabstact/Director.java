package com.example.bootapitest.bookschema.builder.builderabstact;

public class Director {
    Product product;
    public Director(Product product){
        this.product = product;
    }
    void build(){
        product.createUnit();
        product.createUnit2();
        product.createUnit3();
        product.composite();
    }
}
