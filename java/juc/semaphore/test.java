package juc.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * @Author:wanghao
 * @Date: 2022/3/8
 */
public class test {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        System.out.println("三车位");
        ExecutorService executorService = newFixedThreadPool(10);
        for (int i = 0; i < 6; i++) {
            int finalI=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(finalI+"抢占到车位");
                      //  TimeUnit.SECONDS.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        System.out.println(finalI+"把车开走了");
                        semaphore.release();//释放资源
                    }
               }
            });
        }
        executorService.shutdown();
    }
}
