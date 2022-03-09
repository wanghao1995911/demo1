package java8.java8创建多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */


public class FutureDemot {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = newFixedThreadPool(16);
        Future<Integer> submit = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum=0;
                for (int i = 0; i < 520; i++) {
                    sum+=i;
                }
                return sum;
            }
        });
        Integer integer = submit.get();
        System.out.println(integer);
        executorService.shutdown();
    }

    private static class IntegerCallbaleTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int sum=0;
            for (int i = 0; i < 520; i++) {
                sum+=i;
            }
            return sum;
        }
    }


}
