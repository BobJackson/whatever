package com.wangyousong.practice.whatever;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonUtilsTest {

    @Test
    void should_print_json_pretty() {
        String uglyJsonString = "{\"one\":\"AAA\",\"two\":[\"BBB\",\"CCC\"],\"three\":{\"four\":\"DDD\",\"five\":[\"EEE\",\"FFF\"]}}";
        String result = JsonUtils.prettyPrint(uglyJsonString);
        String expected = """
                {
                  "one" : "AAA",
                  "two" : [ "BBB", "CCC" ],
                  "three" : {
                    "four" : "DDD",
                    "five" : [ "EEE", "FFF" ]
                  }
                }
                """.stripTrailing();
        assertEquals(expected, result);
    }
}