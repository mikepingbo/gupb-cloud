package com.gupb.sso.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "json返回结构", description = "json返回结构")
public class HttpJsonResult<T> implements Serializable {

    private static final long serialVersionUID = -8637111819817625638L;

    @ApiModelProperty(value = "是否成功")
    private Boolean success = true;
    // private T rows;
    @ApiModelProperty(value = "返回数据")
    private T data;
    @ApiModelProperty(value = "提示信息")
    private String message;
    @ApiModelProperty(value = "总记录条数，分页时用到")
    private Integer total = 0;
    @ApiModelProperty(value = "返回编码")
    private String code = "200";

    public HttpJsonResult() {}

    public HttpJsonResult(String errorMessage) {
        this.success = false;
        this.message = errorMessage;
        this.code = "500";
    }

    public HttpJsonResult(String code, Boolean bool, String errorMessage) {
        this.success = bool;
        this.message = errorMessage;
        this.code = code;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        if (message != null) {
            this.success = false;
            this.code = "500";
        }
        this.message = message;
    }

    public void setTotal(Integer count) {
        this.total = count;
    }

    public Integer getTotal() {
        return this.total;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message, boolean returnFlag) {
        if (!returnFlag) {
            this.success = false;
            this.code = "500";
        } else {
            this.success = true;
            this.code = "200";
        }
        this.message = message;
    }
}
