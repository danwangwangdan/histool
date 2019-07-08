package com.xhrmyy.histool.model;

import com.xhrmyy.histool.common.BaseModel;

/**
 * @Description:
 * @Author HuangShiming
 * @Date 2019-4-27
 */
public class Notify extends BaseModel {
    private static final long serialVersionUID = -8296428708948290900L;

    public static final int NOTIFY_YES = 1;
    public static final int NOTIFY_NO = 0;
    private Long id;
    private Long patientId;
    private String openId;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
