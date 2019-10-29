package com.longcheng.xxh.energycenter.entity.sys;

public class Gas {
    private int id;
    private String collectionPoint;
    private String description;
    private String tagType;
    private String useType;
    private String dataType;
    private String driveName;
    private String deviceName;
    private String deviceAddress;
    private String tagVal;
    private String readTime;

    public Gas() {
    }

    @Override
    public String toString() {
        return "Gas{" +
                "id=" + id +
                ", collectionPoint='" + collectionPoint + '\'' +
                ", description='" + description + '\'' +
                ", tagType='" + tagType + '\'' +
                ", useType='" + useType + '\'' +
                ", dataType='" + dataType + '\'' +
                ", driveName='" + driveName + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceAddress='" + deviceAddress + '\'' +
                ", tagVal='" + tagVal + '\'' +
                ", readTime='" + readTime + '\'' +
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

    public String getTagVal() {
        return tagVal;
    }

    public void setTagVal(String tagVal) {
        this.tagVal = tagVal;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    public Gas(int id, String collectionPoint, String description, String tagType, String useType, String dataType, String driveName, String deviceName, String deviceAddress, String tagVal, String readTime) {
        this.id = id;
        this.collectionPoint = collectionPoint;
        this.description = description;
        this.tagType = tagType;
        this.useType = useType;
        this.dataType = dataType;
        this.driveName = driveName;
        this.deviceName = deviceName;
        this.deviceAddress = deviceAddress;
        this.tagVal = tagVal;
        this.readTime = readTime;
    }
}
