package com.example.twoSingleton;


import com.example.bootapitest.bookschema.twoSingleton.FileLogger;
import com.example.bootapitest.bookschema.twoSingleton.TesterLog;
import com.example.bootapitest.config.TaotaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
@ContextConfiguration
public class SingletonTest {


    @Test
    public void logTest(){
        FileLogger obj = FileLogger.getInstance();
        obj.write("日志书写");
        obj.write("日志完成");
        obj.close();
    }


    @Test
    public void logTest2(){
        int s = 2;
        TesterLog testerLog = new TesterLog();
        if(s>0){
            testerLog.log("大于0");
        }
        if(s>1){
            testerLog.log("大于1");
        }
    }


    @Test
    public void testSet(){
        Integer[] ints = {1,2,3,2,4,5,6,4,7,3,8,9,3,10};
        List<Integer> integers =  Arrays.asList(ints);

        Set<Integer> sets = new HashSet();
        sets.addAll(integers);
        for (int s:sets){
            System.out.println(s);
        }

    }



}
