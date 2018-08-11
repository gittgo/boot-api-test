package com.example.bootapitest.ruanmou.test0329;

public class Children extends Father {

    public String name;

    public Children(){
        System.out.println("chilren 构造!");
    }

    public void say(){
        System.out.println("chilren name " + name);
    }

    public void test(){
        super.test();
        System.out.println("chilren test");
    }

    public static void call(){
        System.out.println("chilren call");
    }


}
