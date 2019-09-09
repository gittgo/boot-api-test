package com.example.bootapitest.netty.day06open;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author wang cheng wei
 * @date 2019-6-13 17:16
 */
public class TimeClient {

    public void connect(int port,String host)throws Exception{
        // 配置客户端NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new TimeClientHandler());
                }
            });
            // 发起异步连接操作
            ChannelFuture f = b.connect(host,port).sync();

            // 等待客户端链路关闭
            f.channel().closeFuture().sync();

        }finally {
            // 退出 释放NIO线程组
            group.shutdownGracefully();

        }
    }


    public static void main(String[] args) {
        int port = 8080;
        if(args!=null&&args.length>0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        try {
            new TimeClient().connect(port,"127.0.0.1");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
