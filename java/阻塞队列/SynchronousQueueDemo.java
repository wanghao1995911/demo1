package 阻塞队列;

import java.util.concurrent.SynchronousQueue;

/**
 * @Author:wanghao
 * @Date: 2022/2/11
 */
public class SynchronousQueueDemo {


    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue= new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println("put1");
                synchronousQueue.put("1");
                System.out.println("put2");
                synchronousQueue.put("2");
                System.out.println("put3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(()->{
            try {
                synchronousQueue.take();
                System.out.println("get1");
                synchronousQueue.take();
                System.out.println("get2");
                synchronousQueue.take();
                System.out.println("get3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BB").start();

    }
}
