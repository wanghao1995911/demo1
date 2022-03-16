package java8.函数式接口.function接口;

import java.util.function.Function;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */
public class demo1 {
    public static void main(String[] args) {
        Function<String,String> function=(s)->s+"dasd";
        String ttt = function.apply("ttt");

        System.out.println(function.apply("sout"));
    }
}
