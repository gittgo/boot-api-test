package com.example.bootapitest.thread.ClassLock;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWritetLock {

    static int  count;
    static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

    }
    static class MyRunnable implements Runnable{

        static  void writel(){
            lock.readLock().lock();
            try {
                System.out.println("读取数据");
                System.out.println("读取数据为"+Thread.currentThread().getName()+count);
            }catch (Exception e){

            }finally {
                lock.readLock().unlock();
            }
        }

        static void instance(){
            lock.writeLock().lock();
            try{
                count++;
            }catch (Exception e){

            }finally {
                lock.writeLock().unlock();
            }
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
