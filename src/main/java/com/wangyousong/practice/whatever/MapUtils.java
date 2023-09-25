package com.wangyousong.practice.whatever;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class MapUtils {

    private MapUtils() {
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDescending(Map<K, V> unsortedMap) {
        return sortMapByValue(unsortedMap, Comparator.reverseOrder());
    }

    public static Map<String, Integer> sortByValueAscending(Map<String, Integer> unsortedMap) {
        return sortMapByValue(unsortedMap, Comparator.naturalOrder());
    }

    private static <K, V extends Comparable<? super V>> LinkedHashMap<K, V> sortMapByValue(Map<K, V> unsortedMap,
                                                                                           Comparator<V> comparator) {
        return unsortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(comparator))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
