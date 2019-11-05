package com.longcheng.xxh.energycenter.entity.plan;

import java.math.BigDecimal;

public class Plan {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private BigDecimal id;

    /**
     * start_time
     */
    private String startTime;

    /**
     * end_time
     */
    private String endTime;

    /**
     * area
     */
    private String area;

    /**
     * medium_name
     */
    private String mediaName;

    /**
     * plan_number
     */
    private String planNumber;

    /**
     * measure_ment
     */
    private String measureMent;

    /**
     * plan_use_total
     */
    private String planUseTotal;

    /**
     * plan_output_total
     */
    private String planOutputTotal;

    /**
     * create_by
     */
    private String createBy;

    /**
     * create_date
     */
    private String createDate;

    /**
     * remark
     */
    private String remark;


    public Plan() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) { this.mediaName = mediaName;
    }

    public String getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(String planNumber) {
        this.planNumber = planNumber;
    }

    public String getMeasureMent() {
        return measureMent;
    }

    public void setMeasureMent(String measureMent) {
        this.measureMent = measureMent;
    }

    public String getPlanUseTotal() {
        return planUseTotal;
    }

    public void setPlanUseTotal(String planUseTotal) {
        this.planUseTotal = planUseTotal;
    }

    public String getPlanOutputTotal() {
        return planOutputTotal;
    }

    public void setPlanOutputTotal(String planOutputTotal) {
        this.planOutputTotal = planOutputTotal;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "plan{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", area='" + area + '\'' +
                ", mediumName='" + mediaName + '\'' +
                ", planNumber='" + planNumber + '\'' +
                ", measureMent='" + measureMent + '\'' +
                ", planUseTotal='" + planUseTotal + '\'' +
                ", planOutputTotal='" + planOutputTotal + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate='" + createDate + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
