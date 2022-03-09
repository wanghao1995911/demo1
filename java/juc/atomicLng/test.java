package juc.atomicLng;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.concurrent.Executors.*;

/**
 * @Author:wanghao
 * @Date: 2022/3/8
 */
public class test {

    public static void main(String[] args) throws Exception {
        AtomicLong atomicLong = new AtomicLong(0);
        ExecutorService executorService = newFixedThreadPool(16);
        for (int i = 1; i <= 100; i++) {
           executorService.submit(new Task(atomicLong));
           }
        Thread.sleep(2000);
        System.out.println(atomicLong.get());
        executorService.shutdown();
        }


    private static class Task implements Runnable {
        private  final AtomicLong coun;

        public Task(AtomicLong atomicLong) {
           this.coun=atomicLong;
        }

        @Override
        public void run() {
            coun.incrementAndGet();
        }
    }
}
