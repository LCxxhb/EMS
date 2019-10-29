package com.longcheng.xxh.energycenter.entity.sys;

import java.math.BigDecimal;

public class RegionExtend {
    private BigDecimal aid;

    private String aname;

    private String pid;

    private String createdate;

    private String createby;

    private String lastupdatedate;

    private String lastupdateby;

    private String spare1;

    private String spare2;
    private String pname;

    public RegionExtend(BigDecimal aid, String aname, String pid, String createdate, String createby, String lastupdatedate, String lastupdateby, String spare1, String spare2, String pname) {
        this.aid = aid;
        this.aname = aname;
        this.pid = pid;
        this.createdate = createdate;
        this.createby = createby;
        this.lastupdatedate = lastupdatedate;
        this.lastupdateby = lastupdateby;
        this.spare1 = spare1;
        this.spare2 = spare2;
        this.pname = pname;
    }

    public RegionExtend() {
    }

    public BigDecimal getAid() {
        return aid;
    }

    public void setAid(BigDecimal aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public String getLastupdatedate() {
        return lastupdatedate;
    }

    public void setLastupdatedate(String lastupdatedate) {
        this.lastupdatedate = lastupdatedate;
    }

    public String getLastupdateby() {
        return lastupdateby;
    }

    public void setLastupdateby(String lastupdateby) {
        this.lastupdateby = lastupdateby;
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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "RegionExtend{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", pid='" + pid + '\'' +
                ", createdate='" + createdate + '\'' +
                ", createby='" + createby + '\'' +
                ", lastupdatedate='" + lastupdatedate + '\'' +
                ", lastupdateby='" + lastupdateby + '\'' +
                ", spare1='" + spare1 + '\'' +
                ", spare2='" + spare2 + '\'' +
                ", pname='" + pname + '\'' +
                '}';
    }
}
