package com.gupb.seller.model.system;

import java.io.Serializable;
import java.util.Date;

public class DataMaster implements Serializable {

    private static final long serialVersionUID = 2066522567913205508L;

    private String  masterCode;
    private String  masterCd;
    private String masterText;
    private Integer sortOrder;
    private Integer state;
    private Integer createId;
    private String createName;
    private Date createTime;
    private Integer updateId;
    private String updateName;
    private Date updateTime;

    public String getMasterCode() {
        return masterCode;
    }

    public void setMasterCode(String masterCode) {
        this.masterCode = masterCode;
    }

    public String getMasterCd() {
        return masterCd;
    }

    public void setMasterCd(String masterCd) {
        this.masterCd = masterCd;
    }

    public String getMasterText() {
        return masterText;
    }

    public void setMasterText(String masterText) {
        this.masterText = masterText;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
