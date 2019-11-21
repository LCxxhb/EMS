package com.longcheng.xxh.energycenter.entity.act;

public class Address {
    private int id;
    private String driveName;
    private String deviceName;
    private String equName;
    private String type;
    private String equAddress;
    private String elemCount;
    private String elemBytes;

    public String toexcel() {
        return "ID," +
                "DRIVE_NAME," +
                "DEVICE_NAME," +
                "EQU_NAME," +
                "TYPE," +
                "EQU_ADDRESS," +
                "ELEM_COUNT," +
                "ELEM_BYTES"
                ;
    }

    public Address() {
    }

    public Address(int id, String driveName, String deviceName, String equName, String type, String equAddress, String elemCount, String elemBytes) {
        this.id = id;
        this.driveName = driveName;
        this.deviceName = deviceName;
        this.equName = equName;
        this.type = type;
        this.equAddress = equAddress;
        this.elemCount = elemCount;
        this.elemBytes = elemBytes;
    }
}
