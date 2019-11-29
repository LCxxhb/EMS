package com.longcheng.xxh.energycenter.entity.plan;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 *  ems_energy_formula
 * @author xieqi 2019-11-16
 */
public class Formula implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private BigDecimal id;

    /**
     * prodect_name
     */
    private String prodectName;

    /**
     * consume
     */
    private String consume;

    /**
     * output
     */
    private String output;

    /**
     * status
     */
    private String status;

    /**
     * create_date
     */
    private String createDate;

    /**
     * update_date
     */
    private String updateDate;

    /**
     * remark
     */
    private String remark;


    public Formula() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getProdectName() {
        return prodectName;
    }

    public void setProdectName(String prodectName) {
        this.prodectName = prodectName;
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
