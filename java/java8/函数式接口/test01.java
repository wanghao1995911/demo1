package java8.函数式接口;

import org.junit.Test;

import java.util.function.ToIntBiFunction;

/**
 * @Author:wanghao
 * @Date: 2022/3/7
 */
public class test01 {


    @Test
public void test1(){
        Runnable runnable=()-> System.out.println("1");
        runnable.run();

        ToIntBiFunction<Integer,Integer> toIntBiFunction=(n1,n2)->n1+n2;
        int i = toIntBiFunction.applyAsInt(10, 10);
        System.out.println(i);


    }



}
