package java8.函数式接口.consumer接口;

import java.util.function.Consumer;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */
public class demo1 {
    public static void main(String[] args) {
        Consumer<String> consumer=(a)-> System.out.println(a);
        consumer.accept("aaa");
    }
}
