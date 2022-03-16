package java8.lambda;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */


@FunctionalInterface
 interface CustomLambda {
    public void run(int x);
}

public class TestLamda {
    public static void main(String[] args) {
        CustomLambda obj = (x) -> {
            System.out.println("hello#" + x);
        };

        obj.run(1);
    }
}
