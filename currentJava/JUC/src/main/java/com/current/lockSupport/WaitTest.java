package com.current.lockSupport;

/**
 * object.wait()IllegalMonitorStateException 演示
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
