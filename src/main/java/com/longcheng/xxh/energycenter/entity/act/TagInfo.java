package com.longcheng.xxh.energycenter.entity.act;

public class TagInfo {

    private int id;
    private String collectionPoint;
    private String areaName;
    private String branchFactory;
    private String areaId;
    private String description;
    private String tagType;
    private String useType;
    private String dataType;
    private String driveName;
    private String deviceName;
    private String deviceAddress;
    private String projectUnit;

    public String toexcel() {
        return "COLLECTIONPOINT," +
                "AREANAME," +
                "BRANCHFACTORY," +
                "AREAID," +
                "DESCRIPTION," +
                "TAGTYPE," +
                "USETYPE," +
                "DATATYPE," +
                "DRIVENAME," +
                "DEVICENAME," +
                "DEVICEADDRESS," +
                "PROJECTUNIT"
                ;
    }

    public TagInfo() {
    }

    @Override
    public String toString() {
        return "TagInfo{" +
                "id=" + id +
                ", collectionPoint='" + collectionPoint + '\'' +
                ", areaName='" + areaName + '\'' +
                ", branchFactory='" + branchFactory + '\'' +
                ", areaId='" + areaId + '\'' +
                ", description='" + description + '\'' +
                ", tagType='" + tagType + '\'' +
                ", useType='" + useType + '\'' +
                ", dataType='" + dataType + '\'' +
                ", driveName='" + driveName + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceAddress='" + deviceAddress + '\'' +
                ", projectUnit='" + projectUnit + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollectionPoint() {
        return collectionPoint;
    }

    public void setCollectionPoint(String collectionPoint) {
        this.collectionPoint = collectionPoint;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBranchFactory() {
        return branchFactory;
    }

    public void setBranchFactory(String branchFactory) {
        this.branchFactory = branchFactory;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDriveName() {
        return driveName;
    }

    public void setDriveName(String driveName) {
        this.driveName = driveName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public String getProjectUnit() {
        return projectUnit;
    }

    public void setProjectUnit(String projectUnit) {
        this.projectUnit = projectUnit;
    }

    public TagInfo(int id, String collectionPoint, String areaName, String branchFactory, String areaId, String description, String tagType, String useType, String dataType, String driveName, String deviceName, String deviceAddress, String projectUnit) {
        this.id = id;
        this.collectionPoint = collectionPoint;
        this.areaName = areaName;
        this.branchFactory = branchFactory;
        this.areaId = areaId;
        this.description = description;
        this.tagType = tagType;
        this.useType = useType;
        this.dataType = dataType;
        this.driveName = driveName;
        this.deviceName = deviceName;
        this.deviceAddress = deviceAddress;
        this.projectUnit = projectUnit;
    }
}
