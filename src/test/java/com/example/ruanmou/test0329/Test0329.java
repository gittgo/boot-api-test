package com.example.ruanmou.test0329;


import com.example.bootapitest.config.TaotaoApplication;
import com.example.bootapitest.ruanmou.test0329.Children;
import com.example.bootapitest.ruanmou.test0329.Father;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
public class Test0329 {


    @Test
    public void test(){
        Father father = new Children();
//        Father father2 = new Children();

//        father.say();
//        father.test();
//        father.call();
//        Father.call();
//        Children.call();
//        father.ftt();
    }
}
