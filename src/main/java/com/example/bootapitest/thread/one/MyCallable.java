package com.example.bootapitest.thread.one;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("-------------helo");
        return "Hello Word!";
    }
}
