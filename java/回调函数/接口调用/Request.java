package 回调函数.接口调用;


/**
 * @Author:wanghao
 * @Date: 2022/3/10
 */
public class Request {
    public void send(CallBack callBack) throws Exception {
        // 模拟等待响应
        Thread.sleep(3000);
        System.out.println("[Request]:收到响应");
        callBack.processResponse();
    }
}

