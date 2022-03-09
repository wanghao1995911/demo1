package juc.future模式;

import java.util.concurrent.*;

/**
 * @Author:wanghao
 * @Date: 2022/3/8
 *

import java.util.concurrent.*;

/**
 * @auther plg
 * @date 2019/5/17 16:54
 */
public class test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> future =  service.submit(()->{
            TimeUnit.SECONDS.sleep(2); // 模拟延时
            return 10;
        });
    /*    ExecutorService service2 = Executors.newCachedThreadPool();
        Future<String> submit = service2.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(20);
                return "d";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/
        boolean done = future.isDone();
        System.out.println(done);
        //==============================
        System.out.println("do other works.");
        //==============================
        try {
            //获取线程的future的值
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        boolean done1 = future.isDone();
        System.out.println(done1);

        boolean cancelled = future.isCancelled();
        System.out.println(cancelled);
        service.shutdown();
    }
}
