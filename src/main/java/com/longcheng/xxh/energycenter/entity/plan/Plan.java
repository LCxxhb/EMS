package com.longcheng.xxh.energycenter.entity.plan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


/**
 *  ems_energy_plan
 * @author xieqi 2019-11-05
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
     * end_time
     */
    private String endTime;

    /**
     * area
     */
    private String area;

    /**
     * media_name
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

    /**
     * area_id
     */
    private BigDecimal areaId;

    /**
     * media_id
     */
    private BigDecimal mediaId;

    /**
     * branch
     */
    private String branch;

    /**
     * branch_id
     */
    private BigDecimal branchId;

    /**
     * update_by
     */
    private String updateBy;

    /**
     * update_time
     */
    private String updateTime;

    public Plan() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getArea() {
        return area;
    }

    public String getMediaName() {
        return mediaName;
    }

    public String getPlanNumber() {
        return planNumber;
    }

    public String getMeasureMent() {
        return measureMent;
    }

    public String getPlanUseTotal() {
        return planUseTotal;
    }

    public String getPlanOutputTotal() {
        return planOutputTotal;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getRemark() {
        return remark;
    }

    public BigDecimal getAreaId() {
        return areaId;
    }

    public BigDecimal getMediaId() {
        return mediaId;
    }

    public String getBranch() {
        return branch;
    }

    public BigDecimal getBranchId() {
        return branchId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public void setPlanNumber(String planNumber) {
        this.planNumber = planNumber;
    }

    public void setMeasureMent(String measureMent) {
        this.measureMent = measureMent;
    }

    public void setPlanUseTotal(String planUseTotal) {
        this.planUseTotal = planUseTotal;
    }

    public void setPlanOutputTotal(String planOutputTotal) {
        this.planOutputTotal = planOutputTotal;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setAreaId(BigDecimal areaId) {
        this.areaId = areaId;
    }

    public void setMediaId(BigDecimal mediaId) {
        this.mediaId = mediaId;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setBranchId(BigDecimal branchId) {
        this.branchId = branchId;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(id, plan.id) &&
                Objects.equals(startTime, plan.startTime) &&
                Objects.equals(endTime, plan.endTime) &&
                Objects.equals(area, plan.area) &&
                Objects.equals(mediaName, plan.mediaName) &&
                Objects.equals(planNumber, plan.planNumber) &&
                Objects.equals(measureMent, plan.measureMent) &&
                Objects.equals(planUseTotal, plan.planUseTotal) &&
                Objects.equals(planOutputTotal, plan.planOutputTotal) &&
                Objects.equals(createBy, plan.createBy) &&
                Objects.equals(createDate, plan.createDate) &&
                Objects.equals(remark, plan.remark) &&
                Objects.equals(areaId, plan.areaId) &&
                Objects.equals(mediaId, plan.mediaId) &&
                Objects.equals(branch, plan.branch) &&
                Objects.equals(branchId, plan.branchId) &&
                Objects.equals(updateBy, plan.updateBy) &&
                Objects.equals(updateTime, plan.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, area, mediaName, planNumber, measureMent, planUseTotal, planOutputTotal, createBy, createDate, remark, areaId, mediaId, branch, branchId, updateBy, updateTime);
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", area='" + area + '\'' +
                ", mediaName='" + mediaName + '\'' +
                ", planNumber='" + planNumber + '\'' +
                ", measureMent='" + measureMent + '\'' +
                ", planUseTotal='" + planUseTotal + '\'' +
                ", planOutputTotal='" + planOutputTotal + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate='" + createDate + '\'' +
                ", remark='" + remark + '\'' +
                ", areaId=" + areaId +
                ", mediaId=" + mediaId +
                ", branch='" + branch + '\'' +
                ", branchId=" + branchId +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}