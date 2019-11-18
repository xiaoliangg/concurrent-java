package com.current.collection.concurrentHashMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    /**
     * 左移运算符  The signed left shift operator "<<"
     * 右移运算符  the signed right shift operator ">>"
     * 无符号右移运算符 The unsigned right shift operator ">>>"
     *
     */
    @Test
    public void testShift(){

        //正数测试
        int number = 10;
        int r;
        System.out.println("测试原始数:" + number + "-------------------------------");
        System.out.println("number:" + number + "|" + Integer.toBinaryString(number));

        r = number<<1;
        System.out.println(number + "<<1:" + r + "|"  + Integer.toBinaryString(r));
        r = number>>1;
        System.out.println(number + ">>1:" + r + "|"  + Integer.toBinaryString(r));
        r = number>>>1;
        System.out.println(number + ">>>1:" + r + "|"  + Integer.toBinaryString(r));


        //负数测试
        number = -2147483643;
        System.out.println("测试原始数:" + number + "-------------------------------");
        System.out.println("number:" + number + "|" + Integer.toBinaryString(number));

        r = number<<1;
        System.out.println(number + "<<1:" + r + "|"  + Integer.toBinaryString(r));
        r = number>>1;
        System.out.println(number + ">>1:" + r + "|"  + Integer.toBinaryString(r));
        r = number>>>1;
        System.out.println(number + ">>>1:" + r + "|"  + Integer.toBinaryString(r));
    }

    /**
     * hashCode()方法测试
     */
    @Test
    public void testHashCode(){
        String s = "1111";
        Object o = new Object();
        System.out.println(s.hashCode());
        System.out.println(o.hashCode());
    }

    @Test
    public void testHashMap(){
        Map<String,String> map = new HashMap<>();
        map.put("1","ss");
        String s = map.get("1");
        System.out.println(s);
    }
}
