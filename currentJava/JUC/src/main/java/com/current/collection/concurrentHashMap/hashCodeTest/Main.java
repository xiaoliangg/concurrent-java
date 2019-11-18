package com.current.collection.concurrentHashMap.hashCodeTest;

/**
 * 测试hashCode契约: 2、如果两个对象通过equals(Object)比较，结果相等，那么对这两个对象分别调用hashCode方法应该产生相同的整数结果。（PS：这里equals和hashCode说的都是Object类的）
 */
public class Main {
    public static void main(String[] args) {
        ObjectTest a = new ObjectTest();
        a.setS("a");
        ObjectTest b = new ObjectTest();
        b.setS("a");

        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
