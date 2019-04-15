package com.example.bootapitest.netty.day04AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author wang cheng wei
 * @date 2019-4-15 17:31
 */
public class AsyncTimeServerHandler  implements Runnable {


    private int port;

    CountDownLatch latch;
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsyncTimeServerHandler(int port){
        this.port = port;
        try{
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void doAccept(){
//        asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());
    }
}
