package com.longcheng.xxh.energycenter.entity.plan;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * plan
 *
 * @author xieqi 2019-11-09
 */
public class Plan implements Serializable {
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
     * area
     */
    private String area;

    /**
     * media_name
     */
    private String mediaName;

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

    /**
     * area_id
     */
    private Long areaId;

    /**
     * media_id
     */
    private Long mediaId;

    /**
     * update_by
     */
    private String updateBy;

    /**
     * update_time
     */
    private String updateTime;

    /**
     * update_time
     */
    private String beginTime;

    /**
     * update_time
     */
    private String endTime;

    /**
     * plan_type
     */
    private Long planType;

    /**
     * plan_type_name
     */
    private String planTypeName;


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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
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

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getPlanType() {
        return planType;
    }

    public void setPlanType(Long planType) {
        this.planType = planType;
    }

    public String getPlanTypeName() {
        return planTypeName;
    }

    public void setPlanTypeName(String planTypeName) {
        this.planTypeName = planTypeName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}