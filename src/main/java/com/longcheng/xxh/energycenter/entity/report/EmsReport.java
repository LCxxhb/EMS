package com.longcheng.xxh.energycenter.entity.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  ems_report
 * @author lixing 2019-11-16
 */
public class EmsReport implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * areaname
     */
    private String areaname;

    /**
     * areaid
     */
    private String areaid;

    /**
     * branchfactory
     */
    private String branchfactory;

    /**
     * collectionpoint
     */
    private String collectionpoint;

    /**
     * description
     */
    private String description;

    /**
     * tagtype
     */
    private String tagtype;

    /**
     * usetype
     */
    private String usetype;

    /**
     * tagval
     */
    private String tagval;

    /**
     * readtime
     */
    private String readtime;


    public EmsReport() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBranchfactory() {
        return branchfactory;
    }

    public void setBranchfactory(String branchfactory) {
        this.branchfactory = branchfactory;
    }

    public String getCollectionpoint() {
        return collectionpoint;
    }

    public void setCollectionpoint(String collectionpoint) {
        this.collectionpoint = collectionpoint;
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

    public String getTagval() {
        return tagval;
    }

    public void setTagval(String tagval) {
        this.tagval = tagval;
    }

    public String getReadtime() {
        return readtime;
    }

    public void setReadtime(String readtime) {
        this.readtime = readtime;
    }

}