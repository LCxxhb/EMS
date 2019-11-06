package com.longcheng.xxh.energycenter.entity.act;

public class Enti {
    private int id;
    private String BRANCHFACTORY;
    private String AREANAME;
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
    private double max;
    private double min;
    private double sum;
    private double ave;

    public Enti() {
    }

    @Override
    public String toString() {
        return "Enti{" +
                "id=" + id +
                ", BRANCHFACTORY='" + BRANCHFACTORY + '\'' +
                ", AREANAME='" + AREANAME + '\'' +
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
                ", max=" + max +
                ", min=" + min +
                ", sum=" + sum +
                ", ave=" + ave +
                '}';
    }

    public Enti(int id, String BRANCHFACTORY, String AREANAME, String collectionPoint, String description, String tagType, String useType, String dataType, String driveName, String deviceName, String deviceAddress, String tagVal, String readTime, double max, double min, double sum, double ave) {
        this.id = id;
        this.BRANCHFACTORY = BRANCHFACTORY;
        this.AREANAME = AREANAME;
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
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.ave = ave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBRANCHFACTORY() {
        return BRANCHFACTORY;
    }

    public void setBRANCHFACTORY(String BRANCHFACTORY) {
        this.BRANCHFACTORY = BRANCHFACTORY;
    }

    public String getAREANAME() {
        return AREANAME;
    }

    public void setAREANAME(String AREANAME) {
        this.AREANAME = AREANAME;
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

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAve() {
        return ave;
    }

    public void setAve(double ave) {
        this.ave = ave;
    }
}
