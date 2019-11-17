package com.example.bootapitest.netty.day08google.marshalling03;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author wang cheng wei
 * @date 2019-11-15 13:33
 */
@ChannelHandler.Sharable
public class SubReqServerHandler extends ChannelHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Request request = (Request)msg;
        System.out.println("姓名："+request.getName());
        request.setRequestMessage("完毕");
        ctx.writeAndFlush("完毕：" + request.getId());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();// 发生异常，关闭链路
    }
}
