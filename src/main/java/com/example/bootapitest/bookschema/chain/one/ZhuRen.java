package com.example.bootapitest.bookschema.chain.one;

public class ZhuRen extends Handler {

    @Override
    public boolean handle(Request request) {
        if(request.day<=2){
            System.out.println("主任处理");
            return true;
        }else{
            return getNext().handle(request);
        }
    }
}
