package com.example.bootapitest.netty.day08google.marshall2;


import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
/**
 * @author wang cheng wei
 * @date 2019-11-20 16:54
 */
public class ClientHandler extends ChannelHandlerAdapter {


    private byte[] request = ("senninha" + System.getProperty("line.separator")).getBytes();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // TODO Auto-generated method stub
        System.out.println(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        for (int i = 0; i < 500; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(i + "year");
            userInfo.setUsername("senninha");
            ctx.write(userInfo);
            ctx.flush();
        }
        System.out.println("-----------------send over-----------------");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("error");
    }
}
