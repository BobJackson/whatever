package com.wangyousong.practice.whatever;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapUtilsTest {

    @Test
    void should_return_sorted_map_by_value_descending_order() {
        Map<String, Integer> unsortedMap = Map.of(
                "one", 1,
                "two", 2,
                "five", 5,
                "three", 3,
                "four", 4
        );

        Map<String, Integer> sortedMap = MapUtils.sortByValueDescending(unsortedMap);

        assertEquals(5, sortedMap.size());
        assertEquals(5, sortedMap.values().iterator().next());
    }

    @Test
    void should_return_sorted_map_by_value_ascending_order() {
        Map<String, Integer> unsortedMap = Map.of(
                "two", 2,
                "one", 1,
                "five", 5,
                "three", 3,
                "four", 4
        );

        Map<String, Integer> sortedMap = MapUtils.sortByValueAscending(unsortedMap);

        assertEquals(5, sortedMap.size());
        assertEquals(1, sortedMap.values().iterator().next());
    }
}
