package com.example.bootapitest.netty.day08google.marshalltest;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ZubReqClientHandler extends ChannelHandlerAdapter {

    public ZubReqClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Student s = new Student("小红", "5班", 12);
        ctx.writeAndFlush(s);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg+"client");

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }
}
