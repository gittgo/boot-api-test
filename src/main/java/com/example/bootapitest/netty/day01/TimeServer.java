package com.example.bootapitest.netty.day01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wang cheng wei
 * @date 2019-2-23 11:48
 */
public class TimeServer {


    public static void main(String[] args) throws IOException {
        int port = 8080;
        if(args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }catch (IOException E){

        }finally {
            if (serverSocket != null){
                serverSocket.close();
                serverSocket = null;
            }
        }
    }

}
