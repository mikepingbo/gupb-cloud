package com.gupb.page;

import java.util.List;

public class WrapMapperUtil {

    public static <T> WrapMapperResult<T> success(T object) {
        WrapMapperResult<T> result = new WrapMapperResult<T>();
        result.setData(object);
        return result;
    }

    public static <T> WrapMapperResult<Page<T>> list(List<T> object, Integer total) {
        Page<T> listVo = new Page<>();
        listVo.setCount(total);
        listVo.setList(object);
        return WrapMapperUtil.success(listVo);
    }

    public static <T> WrapMapperResult<T> failBiz(String message) {
        WrapMapperResult<T> result = new WrapMapperResult<T>();
        result.setMessage(message);
        result.setCode("500");
        return result;
    }

    public static <T> WrapMapperResult<T> failSys(String message) {
        WrapMapperResult<T> result = new WrapMapperResult<T>();
        result.setMessage(message);
        result.setCode("400");
        return result;
    }

    public static <T> WrapMapperResult<T> failCommon(String errorCode, String message) {
        WrapMapperResult<T> result = new WrapMapperResult<T>();
        result.setMessage(message);
        result.setCode(errorCode);
        return result;
    }
}
