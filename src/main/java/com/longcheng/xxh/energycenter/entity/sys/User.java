package com.longcheng.xxh.energycenter.entity.sys;

import java.io.Serializable;


/**
 *  user
 * @author shadow 2019-09-27
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * uid
     */
    private Integer id;

    /**
     * username
     */
    private String username;

    /**
     * area_id
     */
    private Integer areaId;

    /**
     * create_date
     */
    private String createDate;

    /**
     * create_by
     */
    private String createBy;

    /**
     * last_update_date
     */
    private String lastUpdateDate;

    /**
     * last_update_by
     */
    private String lastUpdateBy;

    /**
     * status
     */
    private String status;

    /**
     * cname
     */
    private String cname;

    /**
     * password
     */
    private String password;

    /**
     * role_id
     */
    private String roleId;

    /**
     * remark1
     */
    private String remark1;

    /**
     * remark2
     */
    private String remark2;

    /**
     * remark4
     */
    private String remark4;

    /**
     * remark3
     */
    private String remark3;

    /**
     * remark5
     */
    private String remark5;


    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

}