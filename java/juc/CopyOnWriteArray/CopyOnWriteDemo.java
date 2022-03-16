package juc.CopyOnWriteArray;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author:wanghao
 * @Date: 2022/3/9
 */
public class CopyOnWriteDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> objects = new CopyOnWriteArrayList<>();
        objects.add("A");
        objects.add("B");
        objects.add("C");
        objects.add("D");
        Iterator<String> iterator = objects.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if("B".equals(next)){
                objects.remove("D");
            }
            if("D".equals(next)){
                objects.add("F");
            }
            System.out.println(objects);
            System.out.println("当前值="+next);
        }

    }

}
