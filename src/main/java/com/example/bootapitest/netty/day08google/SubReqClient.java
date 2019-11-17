//package com.example.bootapitest.netty.day08google;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.handler.codec.protobuf.ProtobufDecoder;
//import io.netty.handler.codec.protobuf.ProtobufEncoder;
//import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
//import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
//
///**
// * @author wang cheng wei
// * @date 2019-11-14 16:16
// */
//public class SubReqClient {
//
//    public void connect(int port, String host) throws InterruptedException {
//        // 配置客户端线程池
//        EventLoopGroup group = new NioEventLoopGroup();
//        try{
//            Bootstrap b = new Bootstrap();
//            b.group(group).channel(NioSocketChannel.class)
//                    .option(ChannelOption.TCP_NODELAY,true)
//                    .handler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
//                            ch.pipeline().addLast(new ProtobufDecoder(SubscribeRespProto.SubscribeResp.getDefaultInstance()));
//                            ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
//                            ch.pipeline().addLast(new ProtobufEncoder());
//                            ch.pipeline().addLast(new SubReqClientHandler());
//                        }
//                    });
//            // 发起异步连接
//            ChannelFuture f = b.connect(host,port).sync();
//            // 等待客户端链路关闭
//            f.channel().closeFuture().sync();
//        }finally {
//            // 推出
//            group.shutdownGracefully();
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        new SubReqClient().connect(8080,"127.0.0.1");
//    }
//}
