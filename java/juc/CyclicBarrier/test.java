package juc.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:wanghao
 * @Date: 2022/3/8
 */


public class test {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        CyclicBarrier cir = new CyclicBarrier(7, new Thread(() -> System.out.println("收集完毕")));
        for (int i = 1; i < 8; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("收集第" + finalI + "龙珠");
                    try {
                        System.out.println("-----");
                        cir.await();
                        System.out.println("++++++");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
