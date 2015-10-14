package com.fpmislata.banco_api.presentation;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public interface JsonTransformer {

    String toJson(Object data);

    <T> T fromJson(String json, Class<T> clazz);

}
