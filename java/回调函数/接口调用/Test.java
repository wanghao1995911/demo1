package 回调函数.接口调用;

/**
 * @Author:wanghao
 * @Date: 2022/3/10
 */
public class Test {
        public static void main(String[] args) throws Exception {
            Request request = new Request();
            System.out.println("[Main]:我开个线程去异步发请求");
            CallBack callBack = new CallBackImpl();
            new Thread(() -> {
                try {
                    request.send(callBack);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            System.out.println("[Main]:请求发完了，我去干点别的");
            Thread.sleep(100000);
        }
    }


