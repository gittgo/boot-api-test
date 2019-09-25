package com.example.bootapitest.netty.day07FrameDecoder.netty7;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author wang cheng wei
 * @date 2019-9-18 17:16
 */
public class SubReqServer {

    public static void main(String[] args) throws Exception{
        int port = 8080;
        if(args !=null&& args.length>0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        new SubReqServer().bind(port);
    }

    public void bind(int port) throws InterruptedException {
        // 配置服务端的NIO 线程组
        EventLoopGroup bossgroup = new NioEventLoopGroup();
        EventLoopGroup workergroup = new NioEventLoopGroup();

        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossgroup,workergroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(
                                    new ObjectDecoder(1024*1024, ClassResolvers.weakCachingResolver(
                                            this.getClass().getClassLoader())));
                            socketChannel.pipeline().addLast(new ObjectEncoder());
                            socketChannel.pipeline().addLast(new SubReqServerHandler());
                        }
                    });
            // 绑定端口。同步等待成功
            ChannelFuture f = b.bind(port).sync();
            // 等待服务端监听端口管理
            f.channel().closeFuture().sync();
        }finally {
            bossgroup.shutdownGracefully();
            workergroup.shutdownGracefully();
        }

    }
}
