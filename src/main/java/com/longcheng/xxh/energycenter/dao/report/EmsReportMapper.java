package com.longcheng.xxh.energycenter.dao.report;


import com.longcheng.xxh.energycenter.entity.report.EmsReport;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * ems_report
 * @author lixing
 * @date 2019/11/15
 */
@Mapper
@Repository
public interface EmsReportMapper {

    /**
     * [新增]
     * @author lixing
     * @date 2019/11/15
     **/
    int insert(EmsReport emsReport);

    /**
     * [刪除]
     * @author lixing
     * @date 2019/11/15
     **/
    int delete(int id);

    /**
     * [更新]
     * @author lixing
     * @date 2019/11/15
     **/
    int update(EmsReport emsReport);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author lixing
     * @date 2019/11/15
     **/
    EmsReport load(int id);

    /**
     * [查詢] 分頁查詢
     * @author lixing
     * @date 2019/11/15
     **/
    List<EmsReport> pageList(int offset,int pagesize);

    /**
     * [查詢] 分頁查詢 count
     * @author lixing
     * @date 2019/11/15
     **/
    int pageListCount(int offset,int pagesize);

    /**
     * [查詢] 按分厂、区域、介质、时间查询气体
     * @author lixing
     * @date 2019/11/15
     **/
    List<HashMap<String,Object>> findGasByFactoryOrAreaOrTagtype(EmsReport emsReport);

    /**
     * [查詢] 按分厂、区域、介质、时间查询水
     * @author lixing
     * @date 2019/11/15
     **/
    List<HashMap<String,Object>> findWaterByFactoryOrAreaOrTagtype(EmsReport emsReport);

    /**
     * [查詢] 查询所有气体
     * @author lixing
     * @date 2019/11/15
     **/
    List<HashMap<String,Object>> findAllGas();

    /**
     * [查詢] 查询所有水
     * @author lixing
     * @date 2019/11/15
     **/
    List<HashMap<String,Object>> findAllWater();
}
