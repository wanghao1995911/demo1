package java8.java8创建多线程;

import java.util.concurrent.*;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */

/*class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程进行计算");
        Thread.sleep(1000);
        int sum=0;
        for (int i = 0; i < 1000; i++) {
            sum=+i;
        }
        return sum;
    }
}*/

public class futureTaskDemo {

    public static void main(String[] args) throws ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        FutureTask<Integer> integerFutureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum=0;
                for (int i = 0; i < 1000; i++) {
                    sum=+i;
                }
                return sum;
            }
        });
        Future<?> submit = executorService.submit(integerFutureTask);
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
