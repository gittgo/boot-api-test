package com.example.bootapitest.ruanmou.testSocket;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class SocketClient {

    public static void main(String[] args) {

        Socket socket = null;
        try{
             socket = new Socket("127.0.0.1",5555);
             UserInfo userInfo = new UserInfo();
             userInfo.setUsername("admin");
             userInfo.setPassword("admin");
             //
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            objectOutputStream.writeObject(userInfo);
            objectOutputStream.flush();
            //
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            Object t = objectInputStream.readObject();
            String s = t.toString();
            System.out.println(s);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = objectInputStream.read(buffer))!=-1 ){
                String count = new String(buffer,0,len);
                System.out.println(count);
            }




            socket.shutdownOutput();
            socket.shutdownInput();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(socket != null){
                    socket.close();
                }
            }catch (IOException ei){
                ei.printStackTrace();
            }

        }



    }
}
