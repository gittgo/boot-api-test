package com.example.bootapitest.bookschema.oneReflect;

public class FileMsg implements IMsg{

    private static final String ssss = "abcd";

    @Override
    public void process(String msg) {// 仿真保存到文件
        System.out.println("Save msg to file");
    }

    public static String getSsss() {
        return ssss;
    }
}
