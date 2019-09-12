package com.example.bootapitest.jdknew.metaspace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wang cheng wei
 * @date 2019-9-9 11:49
 */
public class TestStack {

    private static int count = 0;

    public  void  call (){
        count++ ;
        call();
    }



    public static void main(String[] args) {


        List<byte[]> list = new ArrayList<>();
        int i = 0;
        boolean flag = true;
        while (flag){
            try {
                i++;
                list.add(new byte[1024 * 1024]);//每次增加一个1M大小的数组对象
            }catch (Throwable e){
                e.printStackTrace();
                flag = false;
                System.out.println("count="+i);//记录运行的次数
            }
        }



//        TestStack testStack = new TestStack();

//        try{
//            testStack.call();`
//        }catch (Throwable throwable){
//            System.out.println("______" + count);
//            throwable.printStackTrace();
//        }

    }
}
