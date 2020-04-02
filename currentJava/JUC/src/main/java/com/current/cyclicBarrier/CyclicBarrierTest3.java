package com.current.cyclicBarrier;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * await指定时间的效果
 * 指定超时时间时，到达时间会抛异常并执行后续任务
 * https://www.cnblogs.com/dolphin0520/p/3920397.html
 */
public class CyclicBarrierTest3 {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N);

        for(int i=0;i<N;i++) {
            if(i<N-1)
                new Writer(barrier).start();
            else {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Writer(barrier).start();
            }
        }
    }
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "抛出异常|" +e );
            }catch(BrokenBarrierException e){
                System.out.println(Thread.currentThread().getName() + "抛出异常|" + e);
            } catch (TimeoutException e) {
                System.out.println(Thread.currentThread().getName() + "抛出异常|" + e);
            }
            System.out.println(Thread.currentThread().getName()+"所有线程写入完毕，继续处理其他任务...");
        }
    }
}

