package com.example.bootapitest.jdktest.twooom;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    static class oomObject{}

    // 堆内存泄漏
    public static void main(String[] args) {
        List list = new ArrayList();

        while (true){
            list.add(new oomObject());
        }
    }
}
