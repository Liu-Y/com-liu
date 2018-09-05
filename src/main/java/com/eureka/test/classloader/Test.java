package com.eureka.test.classloader;

/**
 * Created by Administrator on 2018/8/16.
 */
public class Test {

    private int method1(int a,int b){
        return 0;
    }


}

class Test2  extends Test{

    protected int method1(int a, int b) {
        return 0;
    }
}
