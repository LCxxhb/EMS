package com.longcheng.xxh.energycenter.entity.sys;

import java.io.Serializable;
import java.util.Objects;

public class Point implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String createDate;
    private String collectionpoint;
    private String branchfactory;
    private String areaname;
    private String areaid;
    private String description;
    private String tagtype;
    private String usetype;
    private String datatype;
    private String drivename;
    private String devicename;
    private String deviceaddress;
    private String projectunit;

    public Point(Integer id, String createDate, String collectionpoint, String branchfactory, String areaname, String areaid, String description, String tagtype, String usetype, String datatype, String drivename, String devicename, String deviceaddress, String projectunit) {
        this.id = id;
        this.createDate = createDate;
        this.collectionpoint = collectionpoint;
        this.branchfactory = branchfactory;
        this.areaname = areaname;
        this.areaid = areaid;
        this.description = description;
        this.tagtype = tagtype;
        this.usetype = usetype;
        this.datatype = datatype;
        this.drivename = drivename;
        this.devicename = devicename;
        this.deviceaddress = deviceaddress;
        this.projectunit = projectunit;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCollectionpoint() {
        return collectionpoint;
    }

    public void setCollectionpoint(String collectionpoint) {
        this.collectionpoint = collectionpoint;
    }

    public String getBranchfactory() {
        return branchfactory;
    }

    public void setBranchfactory(String branchfactory) {
        this.branchfactory = branchfactory;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTagtype() {
        return tagtype;
    }

    public void setTagtype(String tagtype) {
        this.tagtype = tagtype;
    }

    public String getUsetype() {
        return usetype;
    }

    public void setUsetype(String usetype) {
        this.usetype = usetype;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getDrivename() {
        return drivename;
    }

    public void setDrivename(String drivename) {
        this.drivename = drivename;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getDeviceaddress() {
        return deviceaddress;
    }

    public void setDeviceaddress(String deviceaddress) {
        this.deviceaddress = deviceaddress;
    }

    public String getProjectunit() {
        return projectunit;
    }

    public void setProjectunit(String projectunit) {
        this.projectunit = projectunit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(id, point.id) &&
                Objects.equals(createDate, point.createDate) &&
                Objects.equals(collectionpoint, point.collectionpoint) &&
                Objects.equals(branchfactory, point.branchfactory) &&
                Objects.equals(areaname, point.areaname) &&
                Objects.equals(areaid, point.areaid) &&
                Objects.equals(description, point.description) &&
                Objects.equals(tagtype, point.tagtype) &&
                Objects.equals(usetype, point.usetype) &&
                Objects.equals(datatype, point.datatype) &&
                Objects.equals(drivename, point.drivename) &&
                Objects.equals(devicename, point.devicename) &&
                Objects.equals(deviceaddress, point.deviceaddress) &&
                Objects.equals(projectunit, point.projectunit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createDate, collectionpoint, branchfactory, areaname, areaid, description, tagtype, usetype, datatype, drivename, devicename, deviceaddress, projectunit);
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", createDate='" + createDate + '\'' +
                ", collectionpoint='" + collectionpoint + '\'' +
                ", branchfactory='" + branchfactory + '\'' +
                ", areaname='" + areaname + '\'' +
                ", areaid='" + areaid + '\'' +
                ", description='" + description + '\'' +
                ", tagtype='" + tagtype + '\'' +
                ", usetype='" + usetype + '\'' +
                ", datatype='" + datatype + '\'' +
                ", drivename='" + drivename + '\'' +
                ", devicename='" + devicename + '\'' +
                ", deviceaddress='" + deviceaddress + '\'' +
                ", projectunit='" + projectunit + '\'' +
                '}';
    }
}
