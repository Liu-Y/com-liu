package com.eureka.test.reflect;

/**
 * Created by Administrator on 2018/8/2.
 */
public class ReflectTest {

    public static void main(String[] args){

        try {

            Class<?> cl = Class.forName("com.eureka.test.MapTest");
            Object o = cl.newInstance();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }

    }
}
