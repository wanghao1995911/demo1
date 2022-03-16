package 回调函数.直接调用;

import 回调函数.反射.CallBack;

/**
 * @Author:wanghao
 * @Date: 2022/3/10
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Request request = new Request();
        System.out.println("开线程");
        CallBack callBack = new CallBack();
        new Thread(()->{
            try {
                request.send(callBack);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("关现场");
        Thread.sleep(100);
    }

}
