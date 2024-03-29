package com.example.bootapitest.netty.day02NBIO;

import com.example.bootapitest.netty.day01.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {


    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }

        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("The tiem server is start in port " + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50,10000);

            while (true){
               socket = serverSocket.accept();
               singleExecutor.execute(new TimeServerHandler(socket));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket !=null){
                System.out.println("The time server close");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }


}
