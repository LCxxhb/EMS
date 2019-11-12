package com.longcheng.xxh.energycenter.entity.report;

public class Report {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;
    /**
     * readTime
     */
    private String readTime;
    /**
     * collectionpoint
     */
    private String collectionpoint;
    /**
     * branchfactory
     */
    private String branchfactory;
    /**
     * areaname
     */
    private String areaname;
    /**
     * areaid
     */
    private String areaid;
    /**
     * description
     */
    private String description;
    /**
     * tagtype
     */
    private String tagtype;
    /**
     * tagval
     */
    private String tagval;
    /**
     * usetype
     */
    private String usetype;
    /**
     * datatype
     */
    private String datatype;

    public Report() {
    }

    /**
     * @param id
     * @param readTime
     * @param collectionpoint
     * @param branchfactory
     * @param areaname
     * @param areaid
     * @param description
     * @param tagtype
     * @param tagval
     * @param usetype
     * @param datatype
     */
    public Report(Integer id, String readTime, String collectionpoint, String branchfactory, String areaname, String areaid, String description, String tagtype, String tagval, String usetype, String datatype) {
        this.id = id;
        this.readTime = readTime;
        this.collectionpoint = collectionpoint;
        this.branchfactory = branchfactory;
        this.areaname = areaname;
        this.areaid = areaid;
        this.description = description;
        this.tagtype = tagtype;
        this.tagval = tagval;
        this.usetype = usetype;
        this.datatype = datatype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    public String getCollectionpoint() {
        return collectionpoint;
    }

    public void setCollectionpoint(String collectionpoint) {
        this.collectionpoint = collectionpoint;
    }

    public String getBranchfactory() {
        return branchfactory;
    }

    public void setBranchfactory(String branchfactory) {
        this.branchfactory = branchfactory;
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

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getTagval() {
        return tagval;
    }

    public void setTagval(String tagval) {
        this.tagval = tagval;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", readTime='" + readTime + '\'' +
                ", collectionpoint='" + collectionpoint + '\'' +
                ", branchfactory='" + branchfactory + '\'' +
                ", areaname='" + areaname + '\'' +
                ", areaid='" + areaid + '\'' +
                ", description='" + description + '\'' +
                ", tagtype='" + tagtype + '\'' +
                ", tagval='" + tagval + '\'' +
                ", usetype='" + usetype + '\'' +
                ", datatype='" + datatype + '\'' +
                '}';
    }
}