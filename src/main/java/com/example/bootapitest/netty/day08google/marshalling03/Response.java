package com.example.bootapitest.netty.day08google.marshalling03;

import java.io.Serializable;

/**
 * @author wang cheng wei
 * @date 2019-11-15 13:44
 */
public class Response implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String responseMessage;

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

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
