package com.example.bootapitest.netty.day07FrameDecoder.netty7;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author wang cheng wei
 * @date 2019-9-25 13:16
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeReq req = (SubscribeReq)msg;
        if("Lilinfeng".equalsIgnoreCase(req.getUserName())){
            System.out.println("Server accept client subscribe req [" + req.toString() +"]" );
            ctx.writeAndFlush(resp(req.getSubReqID()));
        }
    }

    private SubscribeResp resp(int subReqID){
        SubscribeResp resp = new SubscribeResp();
        resp.setSubReqID(subReqID);
        resp.setRespCode(0);
        resp.setDesc("Netty book order succeed , 3 days later , sent to the designated address");
        return resp;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close(); // 发生异常，关闭链路
    }

}
