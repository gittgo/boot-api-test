package com.example.bootapitest.bookschema.builder;

public class Product {
    Unit unit;
    Unit2 unit2;
    Unit3 unit3;


    public void createUnit(){
        unit = new Unit();
    } // 创建具体单元1
    public void createUnit2(){
        unit2 = new Unit2();
    } // 创建具体单元2
    public void createUnit3(){
        unit3 = new Unit3();
    } // 创建具体单元3

    public void composite(){   // 合成具体的Product 对象
        // unit + unit2 + unit3
    }

    public static void main(String[] args) {
        Product p = new Product();
        p.createUnit();p.createUnit2();p.createUnit3();
        p.composite();
    }
}
