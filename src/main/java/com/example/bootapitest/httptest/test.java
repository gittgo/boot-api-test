package com.example.bootapitest.httptest;

import java.util.ArrayList;
import java.util.Random;

public class test {

    public static void main(String[] args) throws InterruptedException {

        String s = "http://ip.nibiest.cn:9500/calls";
        for (int i = 0; i < 10000000; i++) {
            String tel = "callee=18202699405&token=";
            String randomStr = generateRandomStr(RANDOM_LENGTH16);
//            System.out.println(RANDOM_LENGTH16 + "位随机数:" + randomStr);
            tel = tel+randomStr;
            // 测试
            String SSS =  HttpClient.doPost(s,tel);
            if(SSS.equals("200")){
                System.out.println(SSS+"---"+randomStr);
                break;
            }else {
                System.out.println(i);
            }
            Thread.sleep(100);
        }



    }

    public static ArrayList<String> strList = new ArrayList<String>();
    public static Random random = new Random();
    public static final int RANDOM_LENGTH1 = 256;
    public static final int RANDOM_LENGTH2 = 512;
    public static final int RANDOM_LENGTH3 = 1024;
    public static final int RANDOM_LENGTH16 = 16;

    static {
        init();
    }


    public static String generateRandomStr(int length) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++) {
            int size = strList.size();
            String randomStr = strList.get(random.nextInt(size));
            sb.append(randomStr);
        }
        return sb.toString();
    }

    public static void init() {
//        int begin = 97;
//        生成小写字母,并加入集合
//        for(int i = begin; i < begin + 26; i++) {
//            strList.add((char)i + "");
//        }
        //生成大写字母,并加入集合
        int begin = 65;
        for(int i = begin; i < begin + 26; i++) {
            strList.add((char)i + "");
        }
        //将0-9的数字加入集合
        for(int i = 0; i < 10; i++) {
            strList.add(i + "");
        }
    }
}
