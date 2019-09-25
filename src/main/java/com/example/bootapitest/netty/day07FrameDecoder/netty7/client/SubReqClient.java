package com.example.bootapitest.netty.day07FrameDecoder.netty7.client;

import com.example.bootapitest.netty.day07FrameDecoder.netty7.SubReqServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;


// 看完该博客    https://www.jianshu.com/p/876223af6f08
/**
 * @author wang cheng wei
 * @date 2019-9-25 13:38
 */
public class SubReqClient {

    public void connent(int port,String host) throws InterruptedException {
        // 配置客户端NIO线程组
        EventLoopGroup grop = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(grop)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(
                                    new ObjectDecoder(1024, ClassResolvers.cacheDisabled(this.getClass().getClassLoader())));
                            ch.pipeline().addLast(new ObjectEncoder());
                            ch.pipeline().addLast(new SubReqClientHandler());
                        }
                    });
            // 发起异步连接操作
            ChannelFuture f = b.connect(host,port).sync();

            // 等待客户端链路关闭
            f.channel().closeFuture().sync();
        }finally {
            // 退出
            grop.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        if(args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
            }
        }
        new SubReqClient().connent(port,"127.0.0.1");
    }
}
