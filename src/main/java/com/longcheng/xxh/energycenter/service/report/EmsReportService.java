package com.longcheng.xxh.energycenter.service.report;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.report.EmsReport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ems_report
 * @author lixing
 * @date 2019/11/15
 */
public interface EmsReportService {

    /**
     * 新增
     */
    public Results insert(EmsReport emsReport);

    /**
     * 更新
     */
    public Results update(EmsReport emsReport);

    /**
     * 根據主鍵 id 查詢
     */
    public EmsReport load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

    /**
     * [查詢] 按分厂、区域、介质、时间查询气
     * @author lixing
     * @date 2019/11/15
     **/
    public Results findGasByFactoryOrAreaOrTagtype(EmsReport emsReport);

    /**
     * [查詢] 按分厂、区域、介质、时间查询水
     * @author lixing
     * @date 2019/11/15
     **/
    public Results findWaterByFactoryOrAreaOrTagtype(EmsReport emsReport);


    /**
     * [查詢] 查询所有气体
     * @author lixing
     * @date 2019/11/15
     **/
    public Results findAllGas();

    /**
     * [查詢] 查询所有水
     * @author lixing
     * @date 2019/11/15
     **/
    public Results findAllWater();
}
