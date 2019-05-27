package com.example.bootapitest.netty.day04AIO;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;


/**
 * @author wang cheng wei
 * @date 2019-4-15 17:42
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel,AsyncTimeServerHandler>{

    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
        attachment.asynchronousServerSocketChannel.accept(attachment,this);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        result.read(byteBuffer,byteBuffer,new ReadCompletionHandler(result));
    }
    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        //
//        AsyncTimeServerHandler asyncTimeServerHandler = (AsyncTimeServerHandler)attachment;
        //
        exc.printStackTrace();
        attachment.latch.countDown();
    }


}
