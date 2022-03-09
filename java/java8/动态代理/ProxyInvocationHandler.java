package java8.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" 🧱 🧱 🧱 进入代理调用处理器 ");
        return method.invoke(target, args);
    }
}

