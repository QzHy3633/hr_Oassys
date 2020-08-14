package com.hr.entity;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AoaAttendsList implements Serializable{
    private Long attendsId;

    private String attendsIp;

    private String attendsRemark;

    private Date attendsTime;

    private Long statusId;

    private Long typeId;

    private Long attendsUserId;

    private String attendHmtime;

    private String weekOfday;

    private Double holidayDays;

    private Date holidayStart;

    private Long userId;//用户ID

    private String userName;//用户姓名

    private String statusName;//状态名称

    private String typeName;//类型名称

    private String deptName;//部门名称

    private String statusColor;//状态颜色

    private String zt;//别名

    private String zc;//别名

    private String cd;//别名

    private String qj;//别名

    private String cc;//别名

    private String kg;//别名


    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getZc() {
        return zc;
    }

    public void setZc(String zc) {
        this.zc = zc;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getQj() {
        return qj;
    }

    public void setQj(String qj) {
        this.qj = qj;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getKg() {
        return kg;
    }

    public void setKg(String kg) {
        this.kg = kg;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getAttendsId() {
        return attendsId;
    }

    public void setAttendsId(Long attendsId) {
        this.attendsId = attendsId;
    }

    public String getAttendsIp() {
        return attendsIp;
    }

    public void setAttendsIp(String attendsIp) {
        this.attendsIp = attendsIp;
    }

    public String getAttendsRemark() {
        return attendsRemark;
    }

    public void setAttendsRemark(String attendsRemark) {
        this.attendsRemark = attendsRemark;
    }

    public Date getAttendsTime() {
        return attendsTime;
    }

    public void setAttendsTime(Date attendsTime) {
        this.attendsTime = attendsTime;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getAttendsUserId() {
        return attendsUserId;
    }

    public void setAttendsUserId(Long attendsUserId) {
        this.attendsUserId = attendsUserId;
    }

    public String getAttendHmtime() {
        return attendHmtime;
    }

    public void setAttendHmtime(String attendHmtime) {
        this.attendHmtime = attendHmtime;
    }

    public String getWeekOfday() {
        return weekOfday;
    }

    public void setWeekOfday(String weekOfday) {
        this.weekOfday = weekOfday;
    }

    public Double getHolidayDays() {
        return holidayDays;
    }

    public void setHolidayDays(Double holidayDays) {
        this.holidayDays = holidayDays;
    }

    public Date getHolidayStart() {
        return holidayStart;
    }

    public void setHolidayStart(Date holidayStart) {
        this.holidayStart = holidayStart;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}