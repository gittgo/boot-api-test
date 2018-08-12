package com.example.bootapitest.bookschema.chain.one;

public class MyChain {
    private Handler one = new ZuZzhang();
    private Handler two = new ZhuRen();
    private Handler three = new JingLi();

    public void createChain(){
        one.setNext(two);
        two.setNext(three);
    }

    public void handle(Request request){
        one.handle(request);
    }
}
