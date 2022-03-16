package map.IfpresentAndAbsent;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author:wanghao
 * @Date: 2022/3/10
 */
@Slf4j
public class computeIdAbsent {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Boolean>  hashMap = new ConcurrentHashMap<>(1000);
        hashMap.put("s1",false);
        hashMap.put("s2",true);
        hashMap.put("s3",true);
        Boolean s1 = hashMap.putIfAbsent("s1", true);
        System.out.println(s1);
        List<String> strings = new ArrayList<>();
        strings.add("s1");
        strings.add("s2");
        strings.add("s3");
        List<String> collect = strings.stream().filter(distinctByKey(s -> s)).collect(Collectors.toList());
        System.out.println(collect);
    }
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}

