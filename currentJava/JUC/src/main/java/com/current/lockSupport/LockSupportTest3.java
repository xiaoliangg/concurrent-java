package com.current.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * 如果因为调用park而阻塞的话，能够响应中断请求(1.中断状态被设置成true,2.被park的线程可以继续向下执行)，但是不会抛出InterruptedException。
 * https://blog.csdn.net/aitangyong/article/details/38373137
 */
public class LockSupportTest3 {
    public static void main(String[] args) throws Exception
    {
        Thread t = new Thread(new Runnable()
        {
            private int count = 0;

            @Override
            public void run()
            {
                long start = System.currentTimeMillis();
                long end = 0;

                while ((end - start) <= 1000)
                {
                    count++;
                    end = System.currentTimeMillis();
                }

                System.out.println("after 1 second.count=" + count);

                //等待或许许可
                LockSupport.park();

                //自行添加sleep，与park方法对比
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println("thread over." + Thread.currentThread().isInterrupted());

            }
        });

        t.start();

        Thread.sleep(8000);
        // 中断线程
        t.interrupt();
        System.out.println("main over");
    }
}
