package com.example.bootapitest.netty.day03NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class MultiplexerTimeServer implements Runnable{












    private Selector selector;
    private ServerSocketChannel servChannel;
    private volatile boolean stop;
    /**
     * 初始化多路复用器.绑定监听端口
     *
     * @param port
     */
    public MultiplexerTimeServer(int port){
        try {
            selector = Selector.open();
            servChannel = ServerSocketChannel.open();
            servChannel.configureBlocking(false);
            servChannel.socket().bind(new InetSocketAddress(port),1024);
            servChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = true;
    }

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Runnable # run()
     */
    @Override
    public void run() {
        while (!stop){

        }

    }
}
