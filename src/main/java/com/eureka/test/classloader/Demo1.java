package com.eureka.test.classloader;

import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

/**
 * Created by Administrator on 2018/7/27.
 */

class A{
    static {
        System.out.println("加载A");
    }
}

class B{
    static {
        System.out.println("加载B");
    }
}


public class Demo1 extends Demo{

    public Demo1(){
        System.out.println("子类构造器+++++");
    }

    static {
        System.out.println("加载 Dome1");
    }

    public static void main(String[] args){
        Demo demo = new Demo1();
        demo.say();
//        System.out.println("执行main 方法");
//        A a = new A();
//        A a1 = new A();

        String encode = Base64Coder.encodeString("aaaasssssssss");
        System.out.println(encode);
        String decode = Base64Coder.decodeString(encode);
        System.out.println(decode);
    }

    public void say(){
        System.out.println("子类say方法++++");
    }
}
