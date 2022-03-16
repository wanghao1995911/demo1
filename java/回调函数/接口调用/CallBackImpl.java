package 回调函数.接口调用;

/**
 * @Author:wanghao
 * @Date: 2022/3/10
 */
public class CallBackImpl implements CallBack {
    @Override
    public void processResponse() {
        System.out.println("[CallBack]:处理响应");
    }
}
