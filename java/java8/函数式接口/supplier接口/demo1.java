package java8.函数式接口.supplier接口;

import java.util.function.Supplier;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */
public class demo1 {
    public static void main(String[] args) {
        Supplier<Integer> supplier=()->1;
        System.out.println(supplier.get());
    }
}
