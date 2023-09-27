package com.wangyousong.practice.whatever;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangyousong.practice.whatever.exception.JsonFormatException;

public class JsonUtils {

    private JsonUtils() {
    }

    public static String prettyPrint(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Object jsonObject = objectMapper.readValue(json, Object.class);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        } catch (JsonProcessingException e) {
            throw new JsonFormatException(e.getMessage());
        }
    }
}
