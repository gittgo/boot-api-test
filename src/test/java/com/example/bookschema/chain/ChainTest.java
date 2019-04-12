package com.example.bookschema.chain;

import com.example.bootapitest.bookschema.chain.one.*;
import com.example.bootapitest.config.TaotaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
public class ChainTest {

    @Test
    public void testChain(){
        Request request = new Request(3);
        MyChain2 myChain = new MyChain2();
        myChain.createChain();
        myChain.handle(request);
    }


    @Test
    public void testfor(){
        List<Integer>
        list = null;
//        for (int i: list) {
//            System.out.println("true");
//        }
        if(list.isEmpty()){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
