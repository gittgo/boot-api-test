package com.example.bootapitest.netty.day08google.marshalling03;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;


/**
 * @author wang cheng wei
 * @date 2019-11-14 16:26
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {

    private int counter;

    static final String ECHO_REQ = "Hi,lilinfeng.Welcone to Netty.$_";

    public SubReqClientHandler(){}

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("This is "+ ++counter + "time receive server :["+msg+"]" );
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10 ; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
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
