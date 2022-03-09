package java8.动态代理;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */
public class SubjectImpl implements Subject{
    @Override
    public String sayHello() {
        System.out.println(" Hello World");
        return "success";
    }
}
