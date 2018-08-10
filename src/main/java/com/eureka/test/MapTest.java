package com.eureka.test;

import com.google.common.hash.HashCode;

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

    public static void main(String[] args) {
//        MapTest mapTest = new MapTest();
//        mapTest.a();
//        mapTest.b();

        int i = 0 ;
        i++;
        System.out.println(i);

        int a = 3014;
        System.out.println("aa".hashCode());
        Map map= new HashMap();
        map.put("aa","aa");
        map.put(3104,"bb");
        System.out.println(map.size()+"----"+map.get(3104));


    }
}
