package com.example.bootapitest.jdknew.oneinterface;

public interface DefaultA {

    default void dmath(){
        System.out.println("this is A.");
    };

    default void dmathtt(){
        System.out.println("this is a2");
    }

}
