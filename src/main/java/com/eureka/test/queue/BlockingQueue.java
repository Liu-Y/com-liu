package com.eureka.test.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 阻塞队列
 * Created by Administrator on 2018/9/5.
 */
public class BlockingQueue {

    private List list = new ArrayList();
    private int maxSize;
    private Object object = new Object();

    BlockingQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    //必然有一个put get方法 线程安全

    public void put(String element) {

        //一定当前线程进入的
        synchronized (object) {
            //带阻塞：如果队列满了，就进入到等待状态
            try {
                if (this.list.size() == this.maxSize) {
                    System.out.println("线程" + Thread.currentThread().getName() + "已经满了，put方法等待中。。。");
                    this.object.wait();
                }
                this.list.add(element);
                System.out.println("线程" + Thread.currentThread().getName() + "添加元素"+element);

                //唤醒其他等待线程
                object.notifyAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void get() {
        synchronized (object) {

            if(this.list.size() == 0){
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "list为空，get方法等待中。。。");
                    this.object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.list.get(list.size()-1);
            this.list.clear();

            //唤醒其他等待线程
            object.notifyAll();
        }
    }


    public static void main(String[] args){
        final BlockingQueue blockingQueue = new BlockingQueue(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                blockingQueue.put("1");
                blockingQueue.put("2");
                blockingQueue.put("3");
                blockingQueue.put("4");
                blockingQueue.put("5");
                blockingQueue.put("6");
            }
        },"t1-put").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                blockingQueue.get();
                blockingQueue.get();
                blockingQueue.get();
                blockingQueue.get();
                blockingQueue.get();
                blockingQueue.get();
                blockingQueue.get();
            }
        },"t2-get").start();

    }
}
