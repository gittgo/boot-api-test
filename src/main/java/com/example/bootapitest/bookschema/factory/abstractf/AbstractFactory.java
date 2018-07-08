package com.example.bootapitest.bookschema.factory.abstractf;

import com.example.bootapitest.bookschema.factory.simplefactory.IBus;
import com.example.bootapitest.bookschema.factory.simplefactory.ICar;

//定义抽象工厂：
public abstract class AbstractFactory {

    public abstract ICar createCar(); // 生产小汽车

    public abstract IBus createBus(); // 生产公交车

}
