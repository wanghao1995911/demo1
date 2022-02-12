package 阻塞队列;

import java.util.concurrent.*;


/**
 * @Author:wanghao
 * @Date: 2022/2/11
 */
/*mq消息队列的底层原理*/

public class BlockingQueue {

    public static void main(String[] args) throws Exception {

        //extracted1();

      //  extracted2();

       // extracted3();

      //  extracted4();
        java.util.concurrent.BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<String>(3);
        blockingQueue.offer("a",2L,TimeUnit.SECONDS);
        blockingQueue.offer("a",2L,TimeUnit.SECONDS);
        blockingQueue.offer("a",2L,TimeUnit.SECONDS);
        System.out.println(blockingQueue.offer("a",2L,TimeUnit.SECONDS));



    }

    private static void extracted4() throws InterruptedException {
        java.util.concurrent.BlockingQueue<String> demo2=new ArrayBlockingQueue<String>(3);
        demo2.put("a");
        demo2.put("a");
        demo2.put("a");
        // demo2.put("x");

        demo2.take();
        demo2.take();
        demo2.take();
    }

    private static void extracted3() {
        java.util.concurrent.BlockingQueue<String> demo2=new ArrayBlockingQueue<String>(3);
        demo2.add("a");
        demo2.add("b");
        demo2.add("c");
        System.out.println(demo2.peek());
        System.out.println(demo2.poll());
        System.out.println(demo2.poll());
        System.out.println(demo2.poll());
        System.out.println(demo2.poll());
    }

    private static void extracted1() {
        java.util.concurrent.BlockingQueue<String> strings = new ArrayBlockingQueue<>(3);
        strings.offer("a");
        strings.offer("b");
        strings.offer("c");
        System.out.println(strings.offer("d"));
    }

    private static void extracted2() {
        java.util.concurrent.BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        //异常，故障
        //队首的元素是
        System.out.println(blockingQueue.element());
    }
}
