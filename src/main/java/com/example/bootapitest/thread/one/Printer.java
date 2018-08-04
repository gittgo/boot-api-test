package com.example.bootapitest.thread.one;

public class Printer implements Runnable {

    private String message;
    public Printer(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        System.out.println(message);
    }
}
