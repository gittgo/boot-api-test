package com.example.jdknewTest.lambda;

import com.example.bootapitest.bookschema.chain.one.Handler;
import com.example.bootapitest.bookschema.factory.abstractf.AbstractFactory;
import com.example.bootapitest.config.TaotaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
public class TestLamd {

    @Test
    public void testlamd(){
//
//        IntUnaryOperator intUnaryOperator = i -> {int j = 3;return i+j;};
//
//        Runnable r1 = ()->{
//            System.out.println(this);
//        };
//
//        Runnable r2 = () ->{
//            System.out.println(toString());
//        };





        //
        String str = "alpha-bravo-charlie";
        HashMap<String,String> map = new HashMap();
        map.put("alpha","Z");
        map.put("bravo","Y");
        map.put("charlie","Z");
//        map.replaceAll(str :: replace);
//        map.replaceAll( (k,v)  -> v.ge);

        map.replaceAll(String :: concat);

//         String newstr = str.replaceAll("alpha","ss");


//        int s;
//        String t;
//        String t = s -> String ::valueOf(s);
//

        Function function = String::valueOf;

        UnaryOperator<String> string = x -> x.toString();










        System.out.println("--------------------");


    }




}
