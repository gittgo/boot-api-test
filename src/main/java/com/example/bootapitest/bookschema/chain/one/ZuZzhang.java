package com.example.bootapitest.bookschema.chain.one;

public class ZuZzhang extends Handler {
    @Override
    public boolean handle(Request request) {
        if(request.day<=1){
            System.out.println("组长处理");
            return true;
        }else{
            return getNext().handle(request);
        }
    }
}
