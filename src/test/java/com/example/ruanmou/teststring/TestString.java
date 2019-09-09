package com.example.ruanmou.teststring;

import com.example.bootapitest.config.TaotaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wang cheng wei
 * @date 2019-9-8 9:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
public class TestString {


    @Test
    public void testStatic(){

    }

    @Test
    public void testintern(){
        String str1 = "计算机";
        String str2 = "计算机";
        System.out.println("str1==str2:" + (str1 == str2)); //true

        String str3 = new String("计算机");
        System.out.println("str1==str3:" + (str1 == str3));  //false
        System.out.println("str1==str3.intern():" + (str1 == str3.intern()));//true
        System.out.println("str2==str3.intern():" + (str2 == str3.intern()));//true

        String str4 = new String("计算机");
        System.out.println("str3==str4:" + (str3 == str4));  //false
        System.out.println("str3.intern()==str4.intern():" + (str3.intern() == str4.intern()));//true


        String str5 = new StringBuilder("软件").append("工程").toString();

        System.out.println("str5.intern() == str5:" + (str5.intern() == str5));  //true
        String tt =  "软件工程";
        boolean t = str5 == "软件工程";
        System.out.println(t);
        System.out.println("str5.intern() == str5:" + (str5.intern() == tt));  //true

//        String tt =  "软件工程";
//        boolean t = str5 == "软件工程";
//        System.out.println(t);
//        System.out.println("str5.intern() == str5:" + (str5.intern() == tt));  //true
//        System.out.println("str5.intern() == str5:" + (str5.intern() == str5));  //false




//        String str6 = new String(new StringBuilder("物联网").append("工程").toString());
//        System.out.println("str6.intern() == str6:" + (str6.intern() == str6));  //true


//        String str7 = "物联网";
        String str8 = new String("物联网");
        System.out.println("str7.intern() == str7:" + (str8.intern() == str8)); //false


//        str1==str2:true
//        str1==str3:false
//        str1==str3.intern():true
//        str2==str3.intern():true
//        str3==str4:false
//        str3.intern()==str4.intern():true
//        str5.intern() == str5:true
//        str6.intern() == str6:true
//        str7.intern() == str7:false
    }


    @Test
    public void teststring2(){
        String str2 = new String("str")+new String("01");
//        str2.intern();
//        String str1 = "str01";
        System.out.println(str2.intern()==str2);
    }
    @Test
    public void teststring3(){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
    @Test
    public void teststring4(){
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4);
    }
}
