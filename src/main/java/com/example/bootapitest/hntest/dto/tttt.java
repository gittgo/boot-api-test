package com.example.bootapitest.hntest.dto;

/**
 * @author wang cheng wei
 * @date 2019-12-25 14:44
 */
public class tttt {

    public static void main(String[] args) {

        double d = 1.1;
        double d2 = 4.4;
        if(d*4 == d2){
            System.out.println(1+"________________________________________");
        }else {
            System.out.println(2+"________________________________________");
        }

        System.out.println(0.1*0.1);
        System.out.println(1-0.9);

        System.out.println(CryptValiUtil.getMD5("TK123456+"));
        System.out.println(CryptValiUtil.getMD5("123456"));
        System.out.println(CryptValiUtil.getMD5("cs4578431"));
        System.out.println(CryptValiUtil.getMD5("3918008"));
        System.out.println(CryptValiUtil.getMD5("xichang"));

    }
}
