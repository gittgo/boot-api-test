package com.example.thireadtest.testthread;

import com.example.bootapitest.config.TaotaoApplication;
import com.example.bootapitest.thread.singlethreadedexecution.dontsafety.Gate;
import com.example.bootapitest.thread.singlethreadedexecution.dontsafety.GateSyn;
import com.example.bootapitest.thread.singlethreadedexecution.dontsafety.UserThread;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
public class TestUserThread {

    @Test
    public void testUserThread(){
        System.out.println("开始执行：");
        Gate gate = new Gate();
//        new UserThread(gate,"Alice","Alaska").start();
//        new UserThread(gate,"Bobby","Brazil").start();
//        new UserThread(gate,"Chris","Canada").start();
    }

    @Test
    public void testUserThreadSyn(){
        System.out.println("开始执行：");
        GateSyn gateSyn = new GateSyn();
        new UserThread(gateSyn,"Alice","Alaska").start();
        new UserThread(gateSyn,"Bobby","Brazil").start();
        new UserThread(gateSyn,"Chris","Canada").start();
    }
}
