package com.eureka.test.thread;

/**
 * Created by Administrator on 2018/7/27.
 */
public class NewThread implements Runnable {

    private static String bo = "true";

    @Override
    public  void run() {
        System.out.println("wait begin enter synchronized");
        synchronized(bo) {
            try {
                System.out.println("等待开始");
                bo.wait();
                System.out.println("等待结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        NewThread n = new NewThread();

        Thread thread = new Thread(n);

        thread.start();

        try {
            Thread.sleep(1000);
            System.out.println("睡一秒钟");
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("notify begin enter synchronized");
        synchronized(bo) {
            System.out.println("notify start");
            bo.notifyAll();
            System.out.println("notify end");
        }

    }
}
