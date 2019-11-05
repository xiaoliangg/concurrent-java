package com.current.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * 因为许可默认是被占用的，调用park()时获取不到许可，所以进入阻塞状态。
 * https://blog.csdn.net/aitangyong/article/details/38373137
 */
public class LockSupportTest1 {
    public static void main(String[] args)
    {
        System.out.println("block start.");
        LockSupport.park();
        System.out.println("block end.");
    }
}
