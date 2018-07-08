package com.example.bootapitest.bookschema.factory.abstractf;

import com.example.bootapitest.bookschema.factory.simplefactory.*;


// 定义高档小汽车工厂
public class UpFactory extends AbstractFactory {

    @Override
    public ICar createCar() {
        return new UpCar();
    }

    @Override
    public IBus createBus() {
        return new UpBus();
    }
}
