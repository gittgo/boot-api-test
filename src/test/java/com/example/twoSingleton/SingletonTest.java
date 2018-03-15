package com.example.twoSingleton;


import com.example.bootapitest.bookschema.twoSingleton.FileLogger;
import com.example.bootapitest.config.TaotaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

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



}
