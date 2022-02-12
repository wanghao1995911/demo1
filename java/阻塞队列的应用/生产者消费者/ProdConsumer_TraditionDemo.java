package 阻塞队列的应用.生产者消费者;


import java.time.LocalDate;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    private Integer num=0;
    private Lock lock= new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void increment() throws Exception{
        lock.lock();
        try {
            while (num!=0){
                //等待
                condition.await();
            }
            //干活
            num++;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            //唤醒
            condition.signalAll();

        } catch (Exception e) {


        }finally {
            lock.unlock();
        }

    }

    //java多线程唤醒必须用while，防止虚假唤醒
    public void decrement() throws Exception{
        lock.lock();
        try {
            while (num==0){
                //等待
                condition.await();
            }
            //干活
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            //唤醒
            condition.signalAll();
        } catch (Exception e) {
        }finally {
            lock.unlock();
        }
    }
}

/**
 * @Author:wanghao
 * @Date: 2022/2/11
 */
//传统版
    //线程 操作方法 资源类
    // 判断 通知

public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {
    ShareData shareData=new ShareData();

    new Thread(()->{
        for (int i = 1; i < 5; i++) {
            try {
                shareData.increment();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    },"aa").start();

        new Thread(()->{
            for (int i = 1; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        },"bb").start();

    }
}
