package com.example.bootapitest.bookschema.factory.simplefactory;

public class CarSimpleFactory {

    public static final String UPTYPE = "uptype";
    public static final String MIDTYPE = "midtype";
    public static final String DNTYPE = "dntype";

    public static ICar create(String mark){
        ICar obj = null;
        if(mark.equals(UPTYPE)){
            obj = new UpCar();
        }else if (mark.equals(MIDTYPE)){
            obj = new MidCar();
        }else{
            obj = new DnCar();
        }
        return obj;
    }
}
