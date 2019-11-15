package com.example.bootapitest.netty.day08google.marshalling03;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author wang cheng wei
 * @date 2019-11-15 13:33
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Request request = (Request) msg;
        System.out.println("Server : " + request.getId() + ", " + request.getName() + ", " + request.getRequestMessage());
        Response response = new Response();
        response.setId(request.getId());
        response.setName("response" + request.getId());
        response.setResponseMessage("响应内容" + request.getId());
        ctx.writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();// 发生异常，关闭链路
    }
}
