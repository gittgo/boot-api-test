package com.example.bootapitest.netty.day08google.marshalling03;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author wang cheng wei
 * @date 2019-11-15 13:25
 */
public class SubReqClient {

    public void connect(int port, String host) throws InterruptedException {
        // 配置客户端线程池
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                            ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                            ch.pipeline().addLast(new SubReqClientHandler());
                        }
                    });
            // 发起异步连接
            ChannelFuture f = b.connect(host,port).sync();
            // 等待客户端链路关闭
            f.channel().closeFuture().sync();
        }finally {
            // 推出
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new SubReqClient().connect(8088,"127.0.0.1");
    }
}