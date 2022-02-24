package map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author:wanghao
 * @Date: 2022/2/17
 */
public class sortedMap {

    public static void main(String[] args) {

        TreeMap<String, String>     ss = new TreeMap<String, String>();
        TreeMap<Character, Integer> tm = new TreeMap<Character,Integer>();
        tm.put('a',11);
        tm.put('b',12);
        tm.put('c',13);
        System.out.println(tm);

        HashSet<String> strings = new HashSet<>();
        strings.add("a");
        strings.add("a");
        System.out.println(strings);

        ArrayList<String> strings1 = new ArrayList<>();

        strings1.add("a");
        strings1.add("a");
        strings1.add("a");
        System.out.println(strings1);

    }
}
