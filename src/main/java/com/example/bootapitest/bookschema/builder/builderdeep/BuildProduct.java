package com.example.bootapitest.bookschema.builder.builderdeep;

import com.example.bootapitest.bookschema.builder.Product;

public class BuildProduct implements IBuild {

    Product product = new Product();
    public void createUnit() {
        // 创建Unit
    }
    public void createUnit2() {
        // 创建Unit2
    }
    public void createUnit3() {
        // 创建Unit3
    }

    @Override
    public Product create() {
        createUnit();createUnit2();createUnit3();
        return product;
    }
}
