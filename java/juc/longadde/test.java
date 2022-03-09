package juc.longadde;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.LongAdder;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @Author:wanghao
 * @Date: 2022/3/8
 */
//相比较atomicLong方法
//当调用的方法从原来的 get 变成了现在的 sum 方法。而

public class test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        LongAdder longAdder = new LongAdder();
        ExecutorService executorService = newFixedThreadPool(16);
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(10);
        }



        //等待所有线程执行完
        Thread.sleep(2000);
        System.out.println(longAdder.sum());
        executorService.shutdown();
    }


    private static class Task implements Runnable {
        private final LongAdder longAdder;

        public Task(LongAdder longAdder) {

            this.longAdder=longAdder;
        }
        @Override
        public void run() {
            longAdder.increment();
        }
    }


}
