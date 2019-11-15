package com.example.bootapitest.netty.day08google.marshalling03;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * @author wang cheng wei
 * @date 2019-11-15 13:45
 */
public class ClientHandler extends ChannelHandlerAdapter {

    public ClientHandler(){}

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 1; i <= 3; i++) {
            Request request = new Request();
            request.setId("" + i);
            request.setName("pro" + i);
            request.setRequestMessage("数据信息" + i);
            ctx.write(request);
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            Response resp = (Response) msg;
            System.out.println("Client : " + resp.getId() + ", " + resp.getName() + ", " + resp.getResponseMessage());
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
