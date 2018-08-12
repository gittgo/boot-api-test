package com.example.bootapitest.bookschema.chain.one;

public class JingLi extends Handler {
    @Override
    public boolean handle(Request request) {
        System.out.println("经理处理");
            return true;
    }
}