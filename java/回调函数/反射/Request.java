package 回调函数.反射;

import java.lang.reflect.Method;

/**
 * @Author:wanghao
 * @Date: 2022/3/10
 */
public class Request {

    public void send(Class clazz, Method method) throws Exception {
        // 模拟等待响应
        Thread.sleep(3000);
        System.out.println("[Request]:收到响应");
        method.invoke(clazz.newInstance());
    }

}
