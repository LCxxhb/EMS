package com.longcheng.xxh.energycenter.entity;

public class Base {
           private  int ID;
           private  String CREATE_DATE;
           private  String COLLECTIONPOINT;

    public Base() {
    }

    public Base(int ID, String CREATE_DATE, String COLLECTIONPOINT) {
        this.ID = ID;
        this.CREATE_DATE = CREATE_DATE;
        this.COLLECTIONPOINT = COLLECTIONPOINT;
    }

    @Override
    public String toString() {
        return "Base{" +
                "ID=" + ID +
                ", CREATE_DATE='" + CREATE_DATE + '\'' +
                ", COLLECTIONPOINT='" + COLLECTIONPOINT + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(String CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public String getCOLLECTIONPOINT() {
        return COLLECTIONPOINT;
    }

    public void setCOLLECTIONPOINT(String COLLECTIONPOINT) {
        this.COLLECTIONPOINT = COLLECTIONPOINT;
    }
}
