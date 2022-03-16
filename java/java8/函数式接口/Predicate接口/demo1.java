package java8.函数式接口.Predicate接口;

import java.util.function.Predicate;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */
public class demo1 {
    public static void main(String[] args) {
        Predicate<String> predicate=(a)->a.isEmpty();
        boolean dd = predicate.test("dd");

        System.out.println(predicate.test("aa"));
    }
}
