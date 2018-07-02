package com.example.bootapitest.jdknew.oneinterface;


public interface DefaultB {

    default void dmath(){
        System.out.println("this is B.");
    };

    default void dmath2(){
        System.out.println("this is B2.");
    };

    @FunctionalInterface
    interface DefaultBt<F,T>{
        T convert(F form);
    }
}
