package juc.threadCommunicuate.juc方式;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */

class AdditionAndSubtraction2{

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException {
        try {
            lock.lock();
            //需要加锁的部分
            //1、判断
            while (number != 0){
                condition.await();
            }
            //2、干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" +number);
            //3、通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {

        try {
            lock.lock();
            //需要加锁的部分
            //1、判断
            while (number == 0){
                condition.await();
            }
            //2、干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3、通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}


/**
 * 题目：现在两个线程，可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量-1，
 * 实现交替，来10轮，变量初始值为0.
 *      1.高内聚低耦合前提下，线程操作资源类
 *      2.判断/干活/通知
 *      3.防止虚假唤醒(判断只能用while，不能用if)
 *		4.标志位
 * 知识小总结：多线程编程套路+while判断+juc
 */
public class ProducersAndConsumersTest {

    public static void main(String[] args) {

        AdditionAndSubtraction2 additionAndSubtraction2 = new AdditionAndSubtraction2();
        ExecutorService executorService = Executors.newCachedThreadPool();

      /*  new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    additionAndSubtraction2.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();*/
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        additionAndSubtraction2.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        additionAndSubtraction2.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


       /* new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    additionAndSubtraction2.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    additionAndSubtraction2.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    additionAndSubtraction2.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
*/

    }

}
