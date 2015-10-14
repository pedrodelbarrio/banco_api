package com.fpmislata.banco_api.presentation.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.banco_api.presentation.JsonTransformer;
import java.io.IOException;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class JsonTransformerImplJackson implements JsonTransformer {

    @Override
    public String toJson(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <T> T fromJSON(String json, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, clazz);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
