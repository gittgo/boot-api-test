package com.example.bootapitest.netty.day04AIO;

import java.util.concurrent.Future;

/**
 * @author wang cheng wei
 * @date 2019-4-15 17:26
 */
public class TimeServer {



    public static void main(String[] args) {


        int port = 8080;
        if(args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){
                // 默认值
            }

        }

        AsyncTimeServerHandler timeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(timeServerHandler,"AIO-AsyncTimeServerHandler-001").start();

    }



}
