package com.example.bootapitest.thread.ClassLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ClassLock {
    public static int count;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new MyRunnable(),"aaa");
        Thread thread1 = new Thread(new MyRunnable(),"BB");

        thread.start();
        thread1.start();
//        thread.join();
//        thread1.join();

        System.out.println("main"+count);

    }

    static class MyRunnable implements Runnable{

        static  void instance(){

            if (lock.tryLock()) {
                try {
                    lock.lock();
                    count++;
                    lock.unlock();
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }else {
                System.out.println("执行其他");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance();
            }
//            lock.unlock();
        }


        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                instance();
            }
            System.out.println(count+Thread.currentThread().getName());
        }
    }
}
