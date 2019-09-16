package com.example.bootapitest.jdktest.twooom;

public class HotSpot {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        HotSpot hotSpot = new HotSpot();
        try {
            hotSpot.stackLeak();
        }catch (Throwable throwable){
            System.out.println("length "+ hotSpot.stackLength);
            throw  throwable;
        }

    }
}
