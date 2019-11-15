package com.example.bootapitest.netty.day08google.marshalling03;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * @author wang cheng wei
 * @date 2019-11-15 11:14
 */
public class SubReqServer {

    public void bind(int port) throws Exception{
        // 配置NIO
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sh) throws Exception {
                            sh.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                            sh.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
//                            sh.pipeline().addLast(new ReadTimeoutHandler(5));
                            sh.pipeline().addLast(new SubReqServerHandler());
                        }
                    });
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new SubReqServer().bind(8088);
    }


}
