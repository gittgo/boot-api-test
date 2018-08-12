package com.example.bookschema.chain;

import com.example.bootapitest.bookschema.chain.one.*;
import com.example.bootapitest.config.TaotaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
