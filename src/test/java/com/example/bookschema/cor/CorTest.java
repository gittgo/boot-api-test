package com.example.bookschema.cor;


import com.example.bootapitest.config.TaotaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
@ContextConfiguration
public class CorTest {


    @Test
    public void leave(){

        String s = "a";
        String s1 = s +"b";
        String s2 = "a" + "b";

        System.out.println(s1);
        System.out.println(s2);
        System.out.println();
        System.out.println(s1.equals("ab"));
        System.out.println(s2 == "ab");
        System.out.println(s1 == "ab");
        System.out.println(s1 == s2);



    }

    @Test
    public void test2(){

        int a = 2;
        System.out.println(2 << 4);

        String s = "hello";
        String[] s2 = {"h","g","t"};
        StringBuffer stringBuffer = new StringBuffer("Good!");
        test22(s,s2,stringBuffer);

        System.out.println(s + s2[0] + stringBuffer);

    }

    public void test22(String string,String[] strings,StringBuffer stringBuffer){
        string = "tt";
        strings[0] = "tt";
        stringBuffer = stringBuffer.append("ttt");


    }

}
