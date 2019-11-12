package com.longcheng.xxh.energycenter.service.report;

import com.longcheng.xxh.energycenter.entity.report.Report;

import java.util.List;

public interface ReportService {

    /**
     * 根據介质类型查詢
     */
    public List<Report> findByTag(String tagType);

    /**
     * 按分厂查询
     */
    public List<Report> findByAreaname(String areaname);

    /**
     * 按区域查询
     */
    public List<Report> findByBranchfactory(String branchfactory);
    /**
     * 按时间查询
     */
    public List<Report> findByReadTime(String readTime);


}
