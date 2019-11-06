package com.longcheng.xxh.energycenter.entity.mass;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 */
public class MediaData implements Serializable {
    private BigDecimal id;

    private BigDecimal mid;

    private String mediaName;

    private String patchName;

    private String projectName;

    private String minimum;

    private String maximum;

    private String mediaData;

    private String unitName;

    private String state;

    private String createDate;

    private String createBy;

    private String lastUpdateDat;

    private String lastUpdateBy;

    private String spare1;

    private String spare2;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public void setMid(BigDecimal mid) {
        this.mid = mid;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getPatchName() {
        return patchName;
    }

    public void setPatchName(String patchName) {
        this.patchName = patchName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getMediaData() {
        return mediaData;
    }

    public void setMediaData(String mediaData) {
        this.mediaData = mediaData;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastUpdateDat() {
        return lastUpdateDat;
    }

    public void setLastUpdateDat(String lastUpdateDat) {
        this.lastUpdateDat = lastUpdateDat;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MediaData other = (MediaData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMid() == null ? other.getMid() == null : this.getMid().equals(other.getMid()))
            && (this.getMediaName() == null ? other.getMediaName() == null : this.getMediaName().equals(other.getMediaName()))
            && (this.getPatchName() == null ? other.getPatchName() == null : this.getPatchName().equals(other.getPatchName()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getMinimum() == null ? other.getMinimum() == null : this.getMinimum().equals(other.getMinimum()))
            && (this.getMaximum() == null ? other.getMaximum() == null : this.getMaximum().equals(other.getMaximum()))
            && (this.getMediaData() == null ? other.getMediaData() == null : this.getMediaData().equals(other.getMediaData()))
            && (this.getUnitName() == null ? other.getUnitName() == null : this.getUnitName().equals(other.getUnitName()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getLastUpdateDat() == null ? other.getLastUpdateDat() == null : this.getLastUpdateDat().equals(other.getLastUpdateDat()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()))
            && (this.getSpare1() == null ? other.getSpare1() == null : this.getSpare1().equals(other.getSpare1()))
            && (this.getSpare2() == null ? other.getSpare2() == null : this.getSpare2().equals(other.getSpare2()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMid() == null) ? 0 : getMid().hashCode());
        result = prime * result + ((getMediaName() == null) ? 0 : getMediaName().hashCode());
        result = prime * result + ((getPatchName() == null) ? 0 : getPatchName().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getMinimum() == null) ? 0 : getMinimum().hashCode());
        result = prime * result + ((getMaximum() == null) ? 0 : getMaximum().hashCode());
        result = prime * result + ((getMediaData() == null) ? 0 : getMediaData().hashCode());
        result = prime * result + ((getUnitName() == null) ? 0 : getUnitName().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getLastUpdateDat() == null) ? 0 : getLastUpdateDat().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        result = prime * result + ((getSpare1() == null) ? 0 : getSpare1().hashCode());
        result = prime * result + ((getSpare2() == null) ? 0 : getSpare2().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mid=").append(mid);
        sb.append(", mediaName=").append(mediaName);
        sb.append(", patchName=").append(patchName);
        sb.append(", projectName=").append(projectName);
        sb.append(", minimum=").append(minimum);
        sb.append(", maximum=").append(maximum);
        sb.append(", mediaData=").append(mediaData);
        sb.append(", unitName=").append(unitName);
        sb.append(", state=").append(state);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", lastUpdateDat=").append(lastUpdateDat);
        sb.append(", lastUpdateBy=").append(lastUpdateBy);
        sb.append(", spare1=").append(spare1);
        sb.append(", spare2=").append(spare2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}