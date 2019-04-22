package com.xhrmyy.histool.model;

import com.xhrmyy.histool.common.BaseModel;

public class QueueResult extends BaseModel {

    private static final long serialVersionUID = -1898027765943284612L;
    public static final int STATUS_WAITING = 2;
    /**
     * 排队序号
     */
    private Long sn;
    private String name;
    /**
     * 预估时间
     */
    private String esTime;
    /**
     * 前面还有多少人
     */
    private Integer frontNo;

    public Long getSn() {
        return sn;
    }

    public void setSn(Long sn) {
        this.sn = sn;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEsTime() {
        return esTime;
    }

    public void setEsTime(String esTime) {
        this.esTime = esTime;
    }

    public Integer getFrontNo() {
        return frontNo;
    }

    public void setFrontNo(Integer frontNo) {
        this.frontNo = frontNo;
    }
}
