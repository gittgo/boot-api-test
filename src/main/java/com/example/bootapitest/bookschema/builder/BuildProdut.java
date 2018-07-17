package com.example.bootapitest.bookschema.builder;

import com.example.bootapitest.bookschema.factory.simplefactory.IBus;

public class BuildProdut implements IBuild {
    Product product = new Product();

    @Override
    public void createUnit() {
        // 创建Unit
    }
    @Override
    public void createUnit2() {
        // 创建Unit2
    }
    @Override
    public void createUnit3() {
        // 创建Unit3
    }
    @Override
    public Product composite() {
        return product;
    }
}
