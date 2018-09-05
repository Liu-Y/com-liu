package com.eureka.test;

import com.google.common.hash.HashCode;
import org.apache.commons.lang.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/4.
 */
public class MapTest {

    public Map map = new HashMap(10);
    public int anInt;

    public void a(){
        map.put("a","+++++=====");
    }

    public void b(){
        System.out.println(map.get("a"));
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        MapTest mapTest = new MapTest();
//        mapTest.a();
//        mapTest.b();

//        int i = 0 ;
//        i++;
//        System.out.println(i);
//
//        int a = 3014;
//        System.out.println("aa".hashCode());
//        Map map= new HashMap();
//        map.put("aa","aa");
//        map.put(3104,"bb");
//        System.out.println(map.size()+"----"+map.get(3104));


        Integer a = 1;
        Integer b = 2;
        System.out.println("a="+a+",b="+b);//a=1,b=2
        //swap方法输出以下结果
        //方法实现 swap(int a,int b)

        swap(a,b);
        System.out.println("a="+a+",b="+b);//a=2,b=1
    }

    public static void swap(Integer a ,Integer b) throws NoSuchFieldException, IllegalAccessException {
        Integer tmp = new Integer(a);
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(a,b.intValue());
        field.set(b,tmp);
    }
}
