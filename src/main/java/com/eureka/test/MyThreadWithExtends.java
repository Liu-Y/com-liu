package com.eureka.test;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/23.
 */
public class MyThreadWithExtends extends Thread {

    private int tickets = 10;

    public static final String STR="str";

    static BigDecimal big = new BigDecimal(0);
    @Override
    public synchronized void run() {

        for (int i = 0; i <= 100; i++) {
            if(tickets>0){
                System.out.println(Thread.currentThread().getName()+"--卖出票：" + tickets--);
            }
        }
    }

    public static void main(String[] args) {
        MyThreadWithExtends thread1 = new MyThreadWithExtends();
//        MyThreadWithExtends thread2 = new MyThreadWithExtends();
//        MyThreadWithExtends thread3 = new MyThreadWithExtends();

        thread1.start();
//        thread2.start();
//        thread3.start();

        //每个线程都独立，不共享资源，每个线程都卖出了10张票，总共卖出了30张。如果真卖票，就有问题了。

//        String d= "2018-05";
//        System.out.println(d.substring(5));
//        System.out.println(d.substring(0,4));
//        switch ("03") {
//            case "01":
//                System.out.println("january");
//                break;
//            case "02":
//                System.out.println("february");
//                break;
//        }

//        BigDecimal s = new BigDecimal("697819.0").divide(new BigDecimal("40"),2,BigDecimal.ROUND_HALF_UP).divide(new BigDecimal("10000"));
//        BigDecimal s = new BigDecimal("0");
//
//        System.out.println("--------"+s.negate());
//
//        String a = "aa";
//        String b = "bb";
//        String c = "cc";
//        Integer d1 = 96;
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());
//        System.out.println(c.hashCode());
//        System.out.println(d1.hashCode());
//
//        List list = new ArrayList();
//        BigDecimal bigDecimal = big;
//        bigDecimal = bigDecimal.add(new BigDecimal(99));
//        System.out.println("======="+bigDecimal);
//        System.out.println("======="+big);
//
//        if(1==1){
//            System.out.println("--------1111111111");
//        }else if(2==2){
//            System.out.println("--------2222222222");
//        }


//        Lock lock = new ReentrantLock();    //注意这个地方

//        try {
//            Class cls = Class.forName("dyedp.test.MapTest");
//            Method[] methods = cls.getDeclaredMethods();
//            for(Method method: methods) {
//                System.out.println(method);
//            }
//
//        }catch (Exception e){
//
//        }
    }
}
