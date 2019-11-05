package com.longcheng.xxh.energycenter.entity.sys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * menu
 *
 * @author shadow 2019-10-10
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private BigDecimal id;

    /**
     * pid
     */
    private BigDecimal pid;

    /**
     * menuname
     */
    private String menuname;

    /**
     * munuurl
     */
    private String munuurl;

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
     * 存储子菜单
     */
    private List<Menu> childMenus;


    /**
     * remark
     */
    private String remark;

    /**
     * spare
     */
    private String spare;


    public Menu() {
    }

    public List<Menu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu> childMenus) {
        this.childMenus = childMenus;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getPid() {
        return pid;
    }

    public void setPid(BigDecimal pid) {
        this.pid = pid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getMunuurl() {
        return munuurl;
    }

    public void setMunuurl(String munuurl) {
        this.munuurl = munuurl;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }

}
