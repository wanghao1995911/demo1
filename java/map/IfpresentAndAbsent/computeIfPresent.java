package map.IfpresentAndAbsent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:wanghao
 * @Date: 2022/3/10
 */
public class computeIfPresent {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Long> hashMap = new ConcurrentHashMap<>();
        hashMap.put("s1",1L);
        Long s1 = hashMap.computeIfPresent("s1", (key, va) -> 100L);
        System.out.println(s1);

    }
}
