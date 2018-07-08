package com.example.bootapitest.bookschema.factory.abstractf;

import com.example.bootapitest.bookschema.factory.simplefactory.DnBus;
import com.example.bootapitest.bookschema.factory.simplefactory.DnCar;
import com.example.bootapitest.bookschema.factory.simplefactory.IBus;
import com.example.bootapitest.bookschema.factory.simplefactory.ICar;

// 定义底档小汽车工厂
public class DnFactory extends AbstractFactory {
    @Override
    public ICar createCar() {
        return new DnCar();
    }

    @Override
    public IBus createBus() {
        return new DnBus();
    }
}
