package com.gupb.sso.util;

import com.gupb.sso.vo.PageVo;

import java.util.List;

public class JsonReturnUtil {

    /**
     * 成功时返回
     * 
     * @param object 返回值
     * @return
     */
    public static <T> HttpJsonResult<T> success(T object) {
        HttpJsonResult<T> result = new HttpJsonResult<T>();
        result.setData(object);
        return result;
    }

    public static <T> HttpJsonResult<PageVo<T>> list(List<T> object, Integer total) {
        PageVo<T> listVo = new PageVo<>();
        listVo.setCount(total);
        listVo.setList(object);
        return JsonReturnUtil.success(listVo);
    }


    /**
     * 错误时返回错误信息，并设置返回的success为false
     * 
     * @param message 提示消息
     * @return
     */
    @Deprecated
    public static <T> HttpJsonResult<T> fail(String message) {
        HttpJsonResult<T> result = new HttpJsonResult<T>();
        result.setMessage(message);
        return result;
    }

    /**
     * 返回业务异常
     * 
     * @author zhaodw
     * @create 2018/8/10 9:32
     * @param message
     * @return HttpJsonResult<T>
     */
    public static <T> HttpJsonResult<T> failBiz(String message) {
        HttpJsonResult<T> result = new HttpJsonResult<T>();
        result.setMessage(message);
        result.setCode("500");
        return result;
    }

    /**
     * 返回系统异常
     * 
     * @author zhaodw
     * @create 2018/8/10 9:37
     * @param message
     * @return HttpJsonResult<T>
     */
    public static <T> HttpJsonResult<T> failSys(String message) {
        HttpJsonResult<T> result = new HttpJsonResult<T>();
        result.setMessage(message);
        result.setCode("400");
        return result;
    }

    /**
     * 无权限访问异常
     *
     * @author gupb
     * @create 2018/10/13 9:37
     * @param errorCode
     * @param message
     * @return HttpJsonResult<T>
     */
    public static <T> HttpJsonResult<T> failCommon(String errorCode, String message) {
        HttpJsonResult<T> result = new HttpJsonResult<T>();
        result.setMessage(message);
        result.setCode(errorCode);
        return result;
    }

}
