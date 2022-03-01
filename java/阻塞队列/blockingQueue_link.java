package 阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author:wanghao
 * @Date: 2022/2/25
 */
public class blockingQueue_link {

    public static void main(String[] args) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(3);
        linkedBlockingQueue.add("a");
        linkedBlockingQueue.add("a");
        linkedBlockingQueue.add("a");
        System.out.println(linkedBlockingQueue.add("a"));



    }

}
