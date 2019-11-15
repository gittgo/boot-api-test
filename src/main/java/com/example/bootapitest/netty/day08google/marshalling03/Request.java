package com.example.bootapitest.netty.day08google.marshalling03;

import java.io.Serializable;

/**
 * @author wang cheng wei
 * @date 2019-11-15 13:34
 */
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String requestMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }
}
