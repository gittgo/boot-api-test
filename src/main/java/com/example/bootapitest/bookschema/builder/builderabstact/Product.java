package com.example.bootapitest.bookschema.builder.builderabstact;

import com.example.bootapitest.bookschema.builder.Unit;
import com.example.bootapitest.bookschema.builder.Unit2;
import com.example.bootapitest.bookschema.builder.Unit3;

public abstract class Product {
    Unit unit;
    Unit2 unit2;
    Unit3 unit3;

    abstract void createUnit();   // 创建
    abstract void createUnit2();
    abstract void createUnit3();
    abstract void composite();
}
