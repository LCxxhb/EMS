package com.longcheng.xxh.energycenter.entity.sys;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *  roles
 * @author shadow 2019-10-10
 */
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private BigDecimal id;

    /**
     * rolename
     */
    private String rolename;

    /**
     * describe
     */
    private String describe;

    /**
     * permission
     */
    private String permission;

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
     * spare
     */
    private String spare;


    public Roles() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }

}
