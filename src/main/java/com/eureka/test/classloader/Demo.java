package com.eureka.test.classloader;

/**
 * Created by Administrator on 2018/7/27.
 */
public class Demo {

    static {
        System.out.println("加载父类----");
    }

    public Demo(){
        System.out.println("父类构造器----");
    }

    public void say(){
        System.out.println("父类say方法-----");
    }

}
