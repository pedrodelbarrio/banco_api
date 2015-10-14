package com.fpmislata.banco_api.presentation;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public interface JsonTransformer {
    
    String toJson(Object object);
    
    <T> T fromJSON (String json, Class<T> clazz);
    
}
