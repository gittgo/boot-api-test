package com.example.bootapitest.netty.day03NIO;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioMy {



    public void testMy() throws IOException {
        //监听客户端连接父管道
        ServerSocketChannel acceptorSvr = ServerSocketChannel.open();
        // 绑定监听端口
        acceptorSvr.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"),8080));
        //  修改阻塞模式.默认是true
        acceptorSvr.configureBlocking(false);
        // 创建Reactor 线程,创建多路复用器并启动线程
        Selector selector = Selector.open();
//        new Thread(new React()).start();
        //将ServerSocketChannel 注册到Reactor
//        SelectionKey key = acceptorSvr.register(selector,SelectionKey.OP_ACCEPT,ioHandler);
        // 多路复用器在线程run方法的无限循环体内轮询准备就绪的Key
        int num = selector.select();
        Set selectedKey = selector.selectedKeys();
        Iterator it = selectedKey.iterator();
        while (it.hasNext()){
            SelectionKey key1 = (SelectionKey) it.next();
        }
        // 6 处理新的接入请求
        SocketChannel channel = acceptorSvr.accept();
        // 7 设置客户端链路非阻塞模式
        channel.configureBlocking(false);
        channel.socket().setReuseAddress(true);
        // 8




    }




}
