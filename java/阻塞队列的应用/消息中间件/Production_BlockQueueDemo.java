package 阻塞队列的应用.消息中间件;

import java.util.PrimitiveIterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:wanghao
 * @Date: 2022/2/12
 */
class MyResource {
    private volatile boolean Flag = true;//默认开启，进行生产与消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myProd() throws Exception {
        String data = null;
        Boolean re = false;
        while (Flag) {
            data = atomicInteger.incrementAndGet() + "";
            System.out.println(data+"数据生产");
            re = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (re) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "success");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "failure");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "生产工作叫停");
    }

    public void consumer() throws Exception {

        String result = null;
        while (Flag) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            System.out.println(result+"数据消费");
            if (null == result || result.equalsIgnoreCase("")) {
                Flag = false;
                System.out.println(Thread.currentThread().getName() + "\t 没取到消息，消费退出"  + "失败");
            }

            System.out.println(Thread.currentThread().getName() + "\t 消费消息" + result + "success");
        }

    }

    public void stop() throws  Exception{
        Flag=false;
    }

}


public class Production_BlockQueueDemo {

    public static void main(String[] args) throws Exception {

        MyResource myResource=new MyResource(new ArrayBlockingQueue<>(3));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"生产启动");
            try {
                myResource.myProd();
            }catch (Exception e){
               e.printStackTrace();
            }


        },"prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"消费");
            try {
                myResource.consumer();
            }catch (Exception e){
                e.printStackTrace();
            }


        },"consumer").start();
        TimeUnit.SECONDS.sleep(5);

        System.out.println("叫停");

        myResource.stop();




    }
}
