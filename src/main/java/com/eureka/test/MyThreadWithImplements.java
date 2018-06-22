package com.eureka.test;

import java.util.*;

/**
 * Created by Administrator on 2018/5/23.
 */
public class MyThreadWithImplements implements Runnable {

    private volatile int tickets = 10;
    private static int count = 1;

    public Map map1 = new HashMap(10);

    @Override
    public void run() {
        tickets++;
        System.out.println(Thread.currentThread().getName()+"---"+tickets);
//        for (int i = 0; i <= 100; i++) {
//            if(tickets>0){
//                System.out.println(Thread.currentThread().getName()+"--卖出票：" + tickets--);
//            }
//        }
    }

    public static void main(String[] args) {
//        MyThreadWithImplements myRunnable = new MyThreadWithImplements();
//        Thread thread1 = new Thread(myRunnable, "窗口一");
//        Thread thread2 = new Thread(myRunnable, "窗口二");
//        Thread thread3 = new Thread(myRunnable, "窗口三");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();

        String a = new String("abc");
        String b = new String("abc");
        System.out.println(a.hashCode()==b.hashCode());

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.forEach(integer -> {
            System.out.println(integer );
        });

        System.out.println("------------------------");
        System.out.println("poll=" + queue.poll());//获取第一个元素并删除
        queue.forEach(integer -> {
            System.out.println(integer);
        });
        System.out.println("------------------------");
        System.out.println(1 << 30 );
        System.out.println(1 << 4 );
        System.out.println("------------------------");
        HashSet hashSet = new HashSet();
        hashSet.add("abcdaaa");
        hashSet.add("cabcbbb");
        hashSet.add("babcccc");
        for (Object object:hashSet){
            System.out.println(object);
        }
        System.out.println("------------------------");
        Iterator<Object> it = hashSet.iterator();
        while (it.hasNext()) {
            Object str = it.next();
            System.out.println(str);
        }
        System.out.println("------------------------");
        TreeSet treeSet = new TreeSet();
        treeSet.add("bbbbasdfa");
        treeSet.add("aaaaa223a");
        treeSet.add("dddddcd2432");
        treeSet.add("cccc5adtee");
        for (Object object:treeSet){
            System.out.println(object);
        }
        System.out.println("------------------------");
        Iterator<Object> it1 = treeSet.iterator();
        while (it1.hasNext()) {
            Object str = it1.next();
            System.out.println(str);
        }

        System.out.println("------------------------");
        Map<String,String> map = new HashMap();
        map.put("abcdaaa","abcdaaa");
        map.put("cabcbbb","cabcbbb");
        map.put("babcccc","babcccc");
        for (String key1 : map.keySet()){
            System.out.println(map.get(key1));
        }

        System.out.println("------------------------");
        Stack v = new Stack();
        //依次将三个元素push入"栈"
        v.push("疯狂Java讲义");
        v.push("轻量级Java EE企业应用实战");
        v.push("疯狂Android讲义");

        //输出：[疯狂Java讲义, 轻量级Java EE企业应用实战 , 疯狂Android讲义]
        System.out.println(v.peek());
        System.out.println(v);


        System.out.println("------------------------");
        LinkedList books = new LinkedList();
        //将字符串元素加入队列的尾部(双端队列)
        books.offer("疯狂Java讲义");
        //将一个字符串元素加入栈的顶部(双端队列)
        books.push("轻量级Java EE企业应用实战");
        //将字符串元素添加到队列的头(相当于栈的顶部)
        books.offerFirst("疯狂Android讲义");
        books.offer("疯狂Java讲义2");
        for (int i = 0; i < books.size() ; i++ )
        {
            System.out.println(books.get(i));
        }
    }

}
