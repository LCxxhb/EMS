package com.longcheng.xxh.energycenter.entity;

import com.alibaba.fastjson.annotation.JSONPOJOBuilder;


public class User {
    private int UID;
    private String USERNAME;
    private int AREA_ID;
    private String CREATE_DATE;
    private String CREATE_BY;
    private String LAST_UPDATE_DATE;
    private String LAST_UPDATE_BY;
    private String STATUS;
    private String CNAME;
    private String PASSWORD;
    private String ROLE_ID;
    private String REMARK1;
    private String REMARK2;
    private String REMARK4;
    private String REMARK3;
    private String REMARK5;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "UID=" + UID +
                ", USERNAME='" + USERNAME + '\'' +
                ", AREA_ID=" + AREA_ID +
                ", CREATE_DATE='" + CREATE_DATE + '\'' +
                ", CREATE_BY='" + CREATE_BY + '\'' +
                ", LAST_UPDATE_DATE='" + LAST_UPDATE_DATE + '\'' +
                ", LAST_UPDATE_BY='" + LAST_UPDATE_BY + '\'' +
                ", STATUS='" + STATUS + '\'' +
                ", CNAME='" + CNAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", ROLE_ID='" + ROLE_ID + '\'' +
                ", REMARK1='" + REMARK1 + '\'' +
                ", REMARK2='" + REMARK2 + '\'' +
                ", REMARK4='" + REMARK4 + '\'' +
                ", REMARK3='" + REMARK3 + '\'' +
                ", REMARK5='" + REMARK5 + '\'' +
                '}';
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public int getAREA_ID() {
        return AREA_ID;
    }

    public void setAREA_ID(int AREA_ID) {
        this.AREA_ID = AREA_ID;
    }

    public String getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(String CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public String getCREATE_BY() {
        return CREATE_BY;
    }

    public void setCREATE_BY(String CREATE_BY) {
        this.CREATE_BY = CREATE_BY;
    }

    public String getLAST_UPDATE_DATE() {
        return LAST_UPDATE_DATE;
    }

    public void setLAST_UPDATE_DATE(String LAST_UPDATE_DATE) {
        this.LAST_UPDATE_DATE = LAST_UPDATE_DATE;
    }

    public String getLAST_UPDATE_BY() {
        return LAST_UPDATE_BY;
    }

    public void setLAST_UPDATE_BY(String LAST_UPDATE_BY) {
        this.LAST_UPDATE_BY = LAST_UPDATE_BY;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getCNAME() {
        return CNAME;
    }

    public void setCNAME(String CNAME) {
        this.CNAME = CNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getROLE_ID() {
        return ROLE_ID;
    }

    public void setROLE_ID(String ROLE_ID) {
        this.ROLE_ID = ROLE_ID;
    }

    public String getREMARK1() {
        return REMARK1;
    }

    public void setREMARK1(String REMARK1) {
        this.REMARK1 = REMARK1;
    }

    public String getREMARK2() {
        return REMARK2;
    }

    public void setREMARK2(String REMARK2) {
        this.REMARK2 = REMARK2;
    }

    public String getREMARK4() {
        return REMARK4;
    }

    public void setREMARK4(String REMARK4) {
        this.REMARK4 = REMARK4;
    }

    public String getREMARK3() {
        return REMARK3;
    }

    public void setREMARK3(String REMARK3) {
        this.REMARK3 = REMARK3;
    }

    public String getREMARK5() {
        return REMARK5;
    }

    public void setREMARK5(String REMARK5) {
        this.REMARK5 = REMARK5;
    }

    public User(int UID, String USERNAME, int AREA_ID, String CREATE_DATE, String CREATE_BY, String LAST_UPDATE_DATE, String LAST_UPDATE_BY, String STATUS, String CNAME, String PASSWORD, String ROLE_ID, String REMARK1, String REMARK2, String REMARK4, String REMARK3, String REMARK5) {
        this.UID = UID;
        this.USERNAME = USERNAME;
        this.AREA_ID = AREA_ID;
        this.CREATE_DATE = CREATE_DATE;
        this.CREATE_BY = CREATE_BY;
        this.LAST_UPDATE_DATE = LAST_UPDATE_DATE;
        this.LAST_UPDATE_BY = LAST_UPDATE_BY;
        this.STATUS = STATUS;
        this.CNAME = CNAME;
        this.PASSWORD = PASSWORD;
        this.ROLE_ID = ROLE_ID;
        this.REMARK1 = REMARK1;
        this.REMARK2 = REMARK2;
        this.REMARK4 = REMARK4;
        this.REMARK3 = REMARK3;
        this.REMARK5 = REMARK5;
    }
}
