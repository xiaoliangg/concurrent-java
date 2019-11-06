package com.current.lockSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * main线程依次唤醒其他线程
 */
public class LockSupportTest4 extends Thread {

    public LockSupportTest4(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        System.out.println("thread 停止执行:" + this.getName());
        LockSupport.park();
        System.out.println("thread 继续执行:" + this.getName());
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        List<Thread> tList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LockSupportTest4 t = new LockSupportTest4("thread" + i);
            t.start();
            tList.add(t);
        }
        for (Thread t: tList) {
            Thread.sleep(3000);
            LockSupport.unpark(t);
        }
    }
}
