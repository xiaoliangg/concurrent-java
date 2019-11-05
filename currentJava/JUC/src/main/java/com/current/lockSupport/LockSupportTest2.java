package com.current.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport是不可重入的，如果一个线程连续2次调用LockSupport.park()，那么该线程一定会一直阻塞下去。
 * https://blog.csdn.net/aitangyong/article/details/38373137
 */
public class LockSupportTest2 {
    public static void main(String[] args) throws Exception
    {
        Thread thread = Thread.currentThread();

        LockSupport.unpark(thread);

        System.out.println("a");
        LockSupport.park();
        System.out.println("b");
        LockSupport.park();
        System.out.println("c");
    }
}

