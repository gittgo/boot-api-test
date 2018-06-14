package com.example.jdknewTest;


import com.example.bootapitest.config.TaotaoApplication;
import com.example.bootapitest.jdknew.oneinterface.DefaultClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.Consumer;

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

    @Test
    public void  lambda(){

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println(o2.compareTo(o1));
                return o2.compareTo(o1);
            }
        });
//        for (String s :names){
//            System.out.println(s);
//        }

    }
}
