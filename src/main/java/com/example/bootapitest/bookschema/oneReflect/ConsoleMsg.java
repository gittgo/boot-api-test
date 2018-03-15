package com.example.bootapitest.bookschema.oneReflect;

public class ConsoleMsg implements IMsg{

    @Override
    public void process(String msg) {
        System.out.println(msg);
    }
}
