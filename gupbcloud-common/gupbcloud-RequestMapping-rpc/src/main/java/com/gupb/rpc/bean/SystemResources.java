package com.gupb.rpc.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SystemResources implements Serializable {

    public final static Integer SCOPE_SELLER = 1;

    public final static Integer SCOPE_ADMIN  = 2;

    private Integer id;
    private Integer pid;
    private String  url;
    private String  content;
    private Date    createTime;
    private Integer type;
    private Integer status;
    private Integer scope;
    private String  resId;
    private String  resIcon;
    private String  sellerScope;

    private String                state;
    private List<SystemResources> children = new ArrayList<SystemResources>();
}