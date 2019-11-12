package com.longcheng.xxh.energycenter.controller.report;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.report.Report;
import com.longcheng.xxh.energycenter.service.report.ReportService;
import com.longcheng.xxh.energycenter.service.sys.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/report")
public class GasReportController {
    @Resource
    private ReportService reportService;
    @Autowired
    private RegionService regionService;
    /**
     * @param tag
     * @return java.lang.String
     * @author lixing
     * @annotation 介质类型查询报表内容
     * @date 2019/10/31 14:21
     */
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping("/findByTag")
    public String findByTagType(String tag) {
        List<Report> reportList = reportService.findByTag(tag);
        Results results = new Results(Code.success, "根据介质类型查询报表内容成功", reportList, "通过介质类型查询报表内容");
        return JSON.toJSONString(results);
    }
    /**
     * @param areaname
     * @return java.lang.String
     * @author lixing
     * @annotation 介质分厂查询报表内容
     * @date 2019/10/31 14:21
     */
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping("/findByAreaname")
    public String findByAreaname(String areaname) {
        List<Report> reportList = reportService.findByAreaname(areaname);
        Results results = new Results(Code.success, "根据介质类型查询报表内容成功", reportList, "通过介质类型查询报表内容");
        return JSON.toJSONString(results);
    }
    /**
     * @param branchfactory
     * @return java.lang.String
     * @author lixing
     * @annotation 介质区域查询报表内容
     * @date 2019/10/31 14:21
     */
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping("/findByBranchfactory")
    public String findByBranchfactory(String branchfactory) {
        List<Report> reportList = reportService.findByBranchfactory(branchfactory);
        Results results = new Results(Code.success, "根据介质类型查询报表内容成功", reportList, "通过介质类型查询报表内容");
        return JSON.toJSONString(results);
    }
}
