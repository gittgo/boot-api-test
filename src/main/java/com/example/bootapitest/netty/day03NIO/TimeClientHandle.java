package com.example.bootapitest.netty.day03NIO;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TimeClientHandle implements Runnable {


    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;

    public TimeClientHandle(String host,int port){
        this.host = host == null ? "127.0.0.1":host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }


    @Override
    public void run() {
        try {
//            doConnect();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        while (!stop){
            try {
                selector.select(1000);

            } catch (Exception e){
                e.printStackTrace();
                System.exit(1);

            }
        }
    }
}
