package com.example.thireadtest.onetest;


import com.example.bootapitest.config.TaotaoApplication;
import com.example.bootapitest.day.v2.day8.Myservlet;
import com.example.bootapitest.thread.one.MyCallable;
import com.example.bootapitest.thread.one.MyThread;
import com.example.bootapitest.thread.one.PrintThread;
import com.example.bootapitest.thread.one.Printer;
import org.apache.ibatis.executor.ExecutorException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
public class BaseTest {

    @Test
    public void testStartThread(){
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println("Good@");
        }
    }

    @Test
    public void testPrintThread(){
        new PrintThread("Good！").start();
        new PrintThread("Nice！").start();
    }

    @Test
    public void testPrient(){
        new Thread(new Printer("good！")).start();
        new Thread(new Printer("nice！")).start();
    }

    @Test
    public void testTheaadFactory() throws InterruptedException {
//        ThreadFactory threadFactory = Executors.defaultThreadFactory();
//        threadFactory.newThread(new Printer("good！")).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("nice");
            Thread.sleep(1000);
        }
    }

    @Test
    public void testCallable(){
        MyCallable myCallable = new MyCallable();
        FutureTask<String> result = new FutureTask<>(myCallable);
        new Thread(result).start();
        try {
            String s = result.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }







}
