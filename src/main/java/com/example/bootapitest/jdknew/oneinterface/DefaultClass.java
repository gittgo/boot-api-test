package com.example.bootapitest.jdknew.oneinterface;

public class DefaultClass implements DefaultA,DefaultB {
    @Override
    public void dmath() {
        DefaultB.super.dmath();
    }
}
