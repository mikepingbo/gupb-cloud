package com.gupb.util.json;

import com.google.gson.Gson;

/**
 * GsonUtils.
 *
 * @author gupb
 */
public class GsonUtils {

    private static final GsonUtils GSON_UTILS = new GsonUtils();

    private static final Gson GSON = new Gson();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static GsonUtils getInstance() {
        return GSON_UTILS;
    }

    /**
     * To json string.
     *
     * @param object the object
     * @return the string
     */
    public String toJson(final Object object) {
        return GSON.toJson(object);
    }

    /**
     * From json t.
     *
     * @param <T>    the type parameter
     * @param json   the json
     * @param tClass the t class
     * @return the t
     */
    public <T> T fromJson(final String json, final Class<T> tClass) {
        return GSON.fromJson(json, tClass);
    }
}
