package com.example.bootapitest.bookschema.chain.one;

public abstract class Handler {
    private Handler next;
    public Handler getNext() {
        return next;
    }
    public void setNext(Handler next) {
        this.next = next;
    }
    public abstract boolean handle(Request request);
}
