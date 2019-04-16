package com.example.bootapitest.netty.day04AIO;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;


/**
 * @author wang cheng wei
 * @date 2019-4-15 17:42
 */
public class AcceptCompletionHandler implements CompletionHandler{

    @Override
    public void completed(Object result, Object attachment) {
        AsyncTimeServerHandler asyncTimeServerHandler = (AsyncTimeServerHandler)attachment;
        AsynchronousSocketChannel acceptCompletionHandler = (AsynchronousSocketChannel)result;

        asyncTimeServerHandler.asynchronousServerSocketChannel.accept(attachment,this);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        acceptCompletionHandler.read(byteBuffer,byteBuffer,new ReadCompletionHandler(acceptCompletionHandler));
    }
    @Override
    public void failed(Throwable exc, Object attachment) {
        //
        AsyncTimeServerHandler asyncTimeServerHandler = (AsyncTimeServerHandler)attachment;
        //
        exc.printStackTrace();
        asyncTimeServerHandler.latch.countDown();
    }


}
