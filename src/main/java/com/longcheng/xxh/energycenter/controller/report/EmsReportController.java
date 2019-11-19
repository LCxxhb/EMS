package com.longcheng.xxh.energycenter.controller.report;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.report.EmsReport;
import com.longcheng.xxh.energycenter.service.report.EmsReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * ems_report
 * @author lixing
 * @date 2019/11/15
 */
@RestController
@RequestMapping(value = "/EmsReport")
public class EmsReportController {

    @Autowired
    private EmsReportService emsReportService;

    /**
     * [新增]
     * @author lixing
     * @date 2019/11/15
     **/
    @PostMapping("/insert")
    public Results insert(EmsReport emsReport){
        return emsReportService.insert(emsReport);
    }

    /**
     * [更新]
     * @author lixing
     * @date 2019/11/15
     **/
    @PostMapping("/update")
    public Results update(EmsReport emsReport){
        return emsReportService.update(emsReport);
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author lixing
     * @date 2019/11/15
     **/
    @PostMapping("/load")
    public EmsReport load(int id){
        return emsReportService.load(id);
    }

    /**
     * [查詢] 分頁查詢
     * @author lixing
     * @date 2019/11/15
     **/
    @PostMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return emsReportService.pageList(offset, pagesize);
    }

    /**
     * [查詢] 分頁查詢
     * @author lixing
     * @date 2019/11/15
     **/
    @PostMapping("/findGasByFactoryOrAreaOrTagtype")
    public String findGasByFactoryOrAreaOrTagtype(EmsReport emsReport) {
        return JSON.toJSONString(emsReportService.findGasByFactoryOrAreaOrTagtype(emsReport));
    }

    /**
     * [查詢] 分頁查詢
     * @author lixing
     * @date 2019/11/15
     **/
    @PostMapping("/findWaterByFactoryOrAreaOrTagtype")
    public String findWaterByFactoryOrAreaOrTagtype(EmsReport emsReport) {
        return JSON.toJSONString(emsReportService.findWaterByFactoryOrAreaOrTagtype(emsReport));
    }
}
