package 回调函数.Lambda表达式;

import 回调函数.接口调用.Request;

/**
 * @Author:wanghao
 * @Date: 2022/3/10
 */
public class Test {
        public static void main(String[] args) throws Exception {
            Request request = new Request();
            System.out.println("[Main]:我开个线程去异步发请求");
            new Thread(() -> {
                try {
                    request.send(()-> System.out.println("[CallBack]:处理响应"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            System.out.println("[Main]:请求发完了，我去干点别的");
            Thread.sleep(100000);
        }
    }

