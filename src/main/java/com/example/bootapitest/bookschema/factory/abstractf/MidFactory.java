package com.example.bootapitest.bookschema.factory.abstractf;

import com.example.bootapitest.bookschema.factory.simplefactory.*;

// 定义中档小汽车工厂
public class MidFactory extends AbstractFactory {
    @Override
    public ICar createCar() {
        return new MidCar();
    }

    @Override
    public IBus createBus() {
        return new MidBus();
    }
}
