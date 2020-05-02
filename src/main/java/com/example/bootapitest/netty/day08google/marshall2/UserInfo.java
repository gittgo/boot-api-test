package com.example.bootapitest.netty.day08google.marshall2;

import java.io.Serializable;

/**
 * @author wang cheng wei
 * @date 2019-11-20 16:52
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 8991188353255269456L;
    private String username;
    private String age;
    public String getUsername() {
        return username;
    }
    public String getAge() {
        return age;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public UserInfo(String username, String age) {
        super();
        this.username = username;
        this.age = age;
    }

    public UserInfo(){

    }
    @Override
    public String toString() {
        return "UserInfo [username=" + username + ", age=" + age + "]";
    }


}
