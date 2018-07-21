package com.example.bootapitest.bookschema.builder.builderdeep;

import com.example.bootapitest.bookschema.builder.Product;

public class Director {

    private IBuild build;
    public Director(IBuild build){
        this.build = build;
    }
    public Product build(){
        return build.create();
    }
}
