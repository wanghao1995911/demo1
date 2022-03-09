package java8.java8创建多线程;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.*;

/**
 * @Author:wanghao
 * @Date: 2022/2/16
 */



public class demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = newFixedThreadPool(10);
        Future<String> xzh = executor.submit(() -> test("xzh"));
        System.out.println(xzh.get());
        //关闭启动线程
        executor.shutdown();
        //子线程是否全部结束
        boolean terminated = executor.isTerminated();
    }

    public static String test(String s){
        System.out.println(s);
        return "success";
    }

}
