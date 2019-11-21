package com.longcheng.xxh.energycenter.entity.act;

public class GatewayInfo {
     private int  id;
     private String  driverName;
     private String   deviceName;
     private String   connType;
     private String   connParam;
     private String   connIp;
     private String  connPort;
     private String   gatewayDesc;

    public GatewayInfo() {
    }

    public GatewayInfo(int id, String driverName, String deviceName, String connType, String connParam, String connIp, String connPort, String gatewayDesc) {
        this.id = id;
        this.driverName = driverName;
        this.deviceName = deviceName;
        this.connType = connType;
        this.connParam = connParam;
        this.connIp = connIp;
        this.connPort = connPort;
        this.gatewayDesc = gatewayDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getConnType() {
        return connType;
    }

    public void setConnType(String connType) {
        this.connType = connType;
    }

    public String getConnParam() {
        return connParam;
    }

    public void setConnParam(String connParam) {
        this.connParam = connParam;
    }

    public String getConnIp() {
        return connIp;
    }

    public void setConnIp(String connIp) {
        this.connIp = connIp;
    }

    public String getConnPort() {
        return connPort;
    }

    public void setConnPort(String connPort) {
        this.connPort = connPort;
    }

    public String getGatewayDesc() {
        return gatewayDesc;
    }

    public void setGatewayDesc(String gatewayDesc) {
        this.gatewayDesc = gatewayDesc;
    }

    @Override
    public String toString() {
        return "GatewayInfo{" +
                "id=" + id +
                ", driverName=" + driverName +
                ", deviceName=" + deviceName +
                ", connType=" + connType +
                ", connParam=" + connParam +
                ", connIp=" + connIp +
                ", connPort=" + connPort +
                ", gatewayDesc=" + gatewayDesc +
                '}';
    }



    public String toexcel() {
        return "DRIVERNAME," +
                "DEVICENAME," +
                "CONNTYPE," +
                "CONNPARAM," +
                "CONNIP," +
                "CONNPORT," +
                "GATEWAYDESC"
                ;
    }


}
