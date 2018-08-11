package com.example.bootapitest.ruanmou.test0329;

public class Father {

    public NameTest name = new NameTest();
    static {
        System.out.println("father static!");
    }

    {
        System.out.println("father 静态!");
    }

    public Father(){
        System.out.println("father 构造");
    }

    public void say(){
        System.out.println("father 构" + name);
    }

    public void test(){
        System.out.println("father test");
    }

    public static void call(){
        System.out.println("father call");
    }

    public final void ftt(){
        System.out.println("father final");
    }
}
