package com.example.jdknewTest;


import com.example.bootapitest.config.TaotaoApplication;
import com.example.bootapitest.jdknew.oneinterface.DefaultClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
@ContextConfiguration
public class DefaultTest {
    @Test
    public void testDefaultA(){
        //Collection
        DefaultClass defaultClass = new DefaultClass();
        defaultClass.dmath();
        defaultClass.dmathtt();
    }
}
