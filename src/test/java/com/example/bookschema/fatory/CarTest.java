package com.example.bookschema.fatory;


import com.example.bootapitest.bookschema.factory.abstractf.AbstractFactory;
import com.example.bootapitest.bookschema.factory.abstractf.UpFactory;
import com.example.bootapitest.bookschema.factory.simplefactory.ICar;
import com.example.bootapitest.config.TaotaoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaotaoApplication.class)
@ContextConfiguration
public class CarTest {

    @Test
    public void abstractFactory(){
        AbstractFactory obj = new UpFactory();
        ICar iCar = obj.create();
    }
}
