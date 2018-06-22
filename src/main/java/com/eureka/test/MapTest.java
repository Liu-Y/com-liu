package com.eureka.test;

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
        MapTest mapTest = new MapTest();
        mapTest.a();
        mapTest.b();
    }
}
