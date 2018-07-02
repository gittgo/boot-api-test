package com.example.bootapitest.jdknew.oneinterface;

@FunctionalInterface
public interface DefaultBt<F,T>{
    T convert(F form);
}