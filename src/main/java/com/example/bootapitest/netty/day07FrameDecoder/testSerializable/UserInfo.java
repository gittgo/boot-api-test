package com.example.bootapitest.netty.day07FrameDecoder.testSerializable;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * @author wang cheng wei
 * @date 2019-9-17 10:06
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 6309417217739408136L;

    private String userName;
    private int userID;

    public UserInfo buildUserName(String userName){
        this.userName = userName;
        return this;
    }

    public UserInfo buildUserID(int userID){
        this.userID = userID;
        return this;
    }

    public final String getUserName(){
        return userName;
    }

    public final void setUserName(String userName){
        this.userName = userName;
    }

    public final int getUserID(){
        return userID;
    }

    public final void setUserID(int userID){
        this.userID = userID;
    }

    public byte[] codeC(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] value = this.userName.getBytes();
        byteBuffer.putInt(value.length);
        byteBuffer.put(value);
        byteBuffer.putInt(this.userID);
        byteBuffer.flip();
        value = null;
        byte[] result = new byte[byteBuffer.remaining()];
        byteBuffer.get(result);
        return result;
    }

    public byte[] codeB(ByteBuffer buffer){
        buffer.clear();
        byte[] value = this.userName.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(userID);
        buffer.flip();
        value = null;
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }




}
