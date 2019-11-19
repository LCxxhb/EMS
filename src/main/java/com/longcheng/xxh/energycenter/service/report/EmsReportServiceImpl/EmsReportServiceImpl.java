package com.longcheng.xxh.energycenter.service.report.EmsReportServiceImpl;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.dao.report.EmsReportMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.report.EmsReport;
import com.longcheng.xxh.energycenter.service.report.EmsReportService;
import com.longcheng.xxh.energycenter.service.sys.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ems_report
 *
 * @author lixing
 * @date 2019/11/15
 */
@Service
public class EmsReportServiceImpl implements EmsReportService {

    @Autowired
    private EmsReportMapper emsReportMapper;


    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Results insert(EmsReport emsReport) {

        return null;
    }


    @Override
    public Results update(EmsReport emsReport) {
        int ret = emsReportMapper.update(emsReport);
        return null;
    }


    @Override
    public EmsReport load(int id) {
        return emsReportMapper.load(id);
    }


    @Override
    public Map<String, Object> pageList(int offset, int pagesize) {

        List<EmsReport> pageList = emsReportMapper.pageList(offset, pagesize);
        int totalCount = emsReportMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }

    @Override
    public Results findGasByFactoryOrAreaOrTagtype(EmsReport emsReport) {
        String apiDesc = "按分厂区域介质时间查询气接口";
        try {

            List<HashMap<String, Object>> lists = emsReportMapper.findGasByFactoryOrAreaOrTagtype(emsReport);
            logger.info("查询到的数据{}", JSON.toJSONString(lists));
            if (lists == null || lists.size() == 0) {
                return new Results(Code.error, "查询数据为空！", lists, apiDesc);
            } else {
                return new Results(Code.success, "查询数据成功", lists, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

    @Override
    public Results findWaterByFactoryOrAreaOrTagtype(EmsReport emsReport) {
        String apiDesc = "按分厂区域介质时间查询水接口";
        try {

            List<HashMap<String, Object>> lists = emsReportMapper.findWaterByFactoryOrAreaOrTagtype(emsReport);
            logger.info("查询到的数据{}", JSON.toJSONString(lists));
            if (lists == null || lists.size() == 0) {
                return new Results(Code.error, "查询数据为空！", lists, apiDesc);
            } else {
                return new Results(Code.success, "查询数据成功", lists, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

    @Override
    public Results findAllGas() {
        String apiDesc = "查询气接口";
        try {
            List<HashMap<String, Object>> lists = emsReportMapper.findAllGas();
            logger.info("查询到的数据{}", JSON.toJSONString(lists));
            if (lists == null || lists.size() == 0) {
                return new Results(Code.error, "查询数据为空！", lists, apiDesc);
            } else {
                return new Results(Code.success, "查询数据成功", lists, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

    @Override
    public Results findAllWater() {
        String apiDesc = "水接口";
        try {
            List<HashMap<String, Object>> lists = emsReportMapper.findAllWater();
            logger.info("查询到的数据{}", JSON.toJSONString(lists));
            if (lists == null || lists.size() == 0) {
                return new Results(Code.error, "查询数据为空！", lists, apiDesc);
            } else {
                return new Results(Code.success, "查询数据成功", lists, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

}
