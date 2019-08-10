package com.example.bootapitest.ruanmou;

public class TestInner {
    public static void main(String[] args) {

//        Outher outher = new Outher();
//        Outher.Inner inner =  outher.new Inner();
//        inner.print();


        // 静态内部类
//        Outher1.inner inner = new Outher1.inner();
//        inner.outprint();
//        Outher1.inner inner2 = new Outher1.inner();
//        inner.outprint();
//        System.out.println(inner+"---"+inner2);

        //匿名内部类
//        new Outher2(){
//            @Override
//            void run() {
//                System.out.println("----------");
//            }
//        }.test(new Outher2() {
//            @Override
//            void run() {
//                System.out.println("++++");
//            }
//        }).run();


        //局部内部类




    }
}

//  匿名内部类
abstract class Outher2{
    abstract void run();

    public Outher2 test(Outher2 outher2){
        return outher2;
    }
}



//2. 嵌套内部类  -> 静态内部类
class Outher1{
    int i = 100;
    static class inner{
        int i = 30;
        void outprint(){
            i+=1;
            System.out.println("静态内部类"+i);
        }
    }
}



// 1 一般内部类
class Outher{
    int i = 100;
    public Outher(){
        System.out.println(i);
    }
    private void outprint(){
        System.out.println("外部类"+i);
    }
    public class Inner{
        int i = 20;
        public Inner(){
            System.out.println("实例化");
        }
        public void print (){
            outprint();
            System.out.println(Inner.this.i);
            System.out.println(Outher.this.i);
            System.out.println(i);
        }
    }



}
