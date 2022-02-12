package 阻塞队列的应用.lock相比较Synchronize的;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:wanghao
 * @Date: 2022/2/12
 */
class ShareDemo {
    private int number = 1;//a 1 b 2 c 3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 2;
            c2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;
            c3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {  lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;
            c1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

public class SyncAndReentrantLockDemo {

    public static void main(String[] args) throws Exception{
        //一把锁里有三把备用钥匙,线程操作资源类
        ShareDemo shareDemo = new ShareDemo();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                {
                    shareDemo.print5();
                }
            }

        }, "aaa").start();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                {
                    shareDemo.print10();
                }
            }

        }, "bbb").start();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                {
                    shareDemo.print15();
                }
            }

        }, "ccc").start();

    }
}
