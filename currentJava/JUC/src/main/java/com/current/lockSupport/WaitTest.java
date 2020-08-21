package com.current.lockSupport;

/**
 * object.wait()IllegalMonitorStateException 演示：wait让线程阻塞前，必须通过synchronized获取同步锁,否则抛异常
 */
public class WaitTest {
    public static void main(String[] args) {
        Object o = new Object();
        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
