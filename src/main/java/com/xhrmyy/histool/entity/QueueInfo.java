package com.xhrmyy.histool.entity;

import com.xhrmyy.histool.common.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Description:
 * @Author HuangShiming
 * @Date 2019-4-21
 */
@Entity
@Table(name = "v_queue_info")
public class QueueInfo extends BaseModel {

    private static final long serialVersionUID = 325141355507080613L;
    @Id
    @Column(name = "room")
    private String room;
    @Column(name = "patientName")
    private String patientName;
    @Column(name = "status")
    private Integer status;
    @Column(name = "sn")
    private Long sn;
    @Column(name = "queueTime")
    private Date queueTime;
    @Column(name = "callTime")
    private Date callTime;
    @Column(name = "officeId")
    private Integer officeId;
    @Column(name = "office")
    private String office;


    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSn() {
        return sn;
    }

    public void setSn(Long sn) {
        this.sn = sn;
    }

    public Date getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(Date queueTime) {
        this.queueTime = queueTime;
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
