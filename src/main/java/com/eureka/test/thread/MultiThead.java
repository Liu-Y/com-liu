package com.eureka.test.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/8/2.
 */
public class MultiThead implements Runnable{

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.intValue());
    }

    public static void main(String[] args){
        MultiThead mt=new MultiThead();
        Thread thread = new Thread(mt);
        Thread thread1 = new Thread(mt);
        thread.start();
        thread1.start();
    }
}
