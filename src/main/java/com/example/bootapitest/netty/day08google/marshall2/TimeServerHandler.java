package com.example.bootapitest.netty.day08google.marshall2;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
/**
 * @author wang cheng wei
 * @date 2019-11-20 16:53
 */
public class TimeServerHandler  extends ChannelHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // TODO Auto-generated method stub
//      ByteBuf in = (ByteBuf) msg;
        try {
            System.out.println(msg);
            String remsg = new String("has receive");
            ctx.write(remsg);
            ctx.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        ctx.flush();
    }
}
