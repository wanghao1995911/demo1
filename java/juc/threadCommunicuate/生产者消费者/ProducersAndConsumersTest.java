package juc.threadCommunicuate.生产者消费者;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */

/**
 * 资源类
 */
class AdditionAndSubtraction{

    private int number = 0;

    //number加1
    public synchronized void increment() throws InterruptedException {
        //判断
        while(number != 0){
            this.wait();
        }
        //干活
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //通知
        this.notifyAll();
    }

    //number减1
    public synchronized void decrement() throws InterruptedException {
        //判断
        while(number == 0){
            this.wait();
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //通知
        this.notifyAll();
    }
}


/**
 * 题目：现在两个线程，可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量-1，
 * 实现交替，来10轮，变量初始值为0.
 *      1.高内聚低耦合前提下，线程操作资源类
 *      2.判断/干活/通知
 *      3.防止虚假唤醒(判断只能用while，不能用if)
 * 知识小总结：多线程编程套路+while判断+juc
 * @author wanghao
 */
public class ProducersAndConsumersTest {

    public static void main(String[] args) {
        AdditionAndSubtraction additionAndSubtraction = new AdditionAndSubtraction();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        additionAndSubtraction.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        additionAndSubtraction.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        additionAndSubtraction.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "C").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        additionAndSubtraction.decrement();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "D").start();
    }

}

