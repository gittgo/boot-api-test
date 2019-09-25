package com.example.bootapitest.netty.day07FrameDecoder.netty7.client;

import com.example.bootapitest.netty.day07FrameDecoder.netty7.SubscribeReq;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author wang cheng wei
 * @date 2019-9-25 13:52
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {

    /**
     * Creates a client-side handler.
     */
    public SubReqClientHandler(){}

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReq subReq(int i){
        SubscribeReq req = new SubscribeReq();
        req.setAddress("南京市江宁区万山国家地质公园");
        req.setPhoneNumber("138*******");
        req.setProductName("Netty 权威指南");
        req.setSubReqID(i);
        req.setUserName("Lilinfeng");
        return req;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response : [" + msg + "]");
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
