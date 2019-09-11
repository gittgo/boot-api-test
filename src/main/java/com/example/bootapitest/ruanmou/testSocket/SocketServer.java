package com.example.bootapitest.ruanmou.testSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static final int port = 5555;


    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;

        while (true) {

            try {
                serverSocket = new ServerSocket(port);
                //
                System.out.println("等待---------");
                socket = serverSocket.accept();
                System.out.println("有访问了");

                ObjectInputStream ob = new ObjectInputStream(socket.getInputStream());

                UserInfo userInfo = (UserInfo) ob.readObject();

                // 创建输出流
                ObjectOutputStream oo = new ObjectOutputStream(socket.getOutputStream());

                if (userInfo.getUsername().equals("admin")) {
                    System.out.println(userInfo.getUsername());
                    System.out.println("登录成功");
                    String SS = new String("登录成功");
                    oo.writeObject(SS);
                } else {
                    System.out.println(userInfo.getUsername());
                    System.out.println("登录失败");
                    oo.writeObject("登录失败".getBytes());
                }

                oo.flush();
                oo.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (serverSocket != null) {
                        serverSocket.close();
                    }
                } catch (IOException io) {
                    io.printStackTrace();
                }

            }
        }
    }
}
