package com.longcheng.xxh.energycenter.dao.plan;

import com.longcheng.xxh.energycenter.entity.plan.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * menu
 * @author xieqi
 * @date 2019/10/10
 */
@Mapper
@Repository
public interface PlanMapper {


    /**
     * [新增]
     * @author xieqi
     * @date 2019/10/18
     **/
    int add(Plan plan);

    /**
     * [刪除]
     * @author xieqi
     * @date 2019/10/18
     **/
    int delete(int id);

    /**
     * [更新]
     * @author xieqi
     * @date 2019/10/18
     **/
    int update(Plan plan);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author xieqi
     * @date 2019/10/18
     **/
    Plan findById(int id);

    /**
     * [查詢] 分頁查詢
     * @author xieqi
     * @date 2019/10/18
     **/
    List<Plan> pageList(int offset, int pagesize);

    /**
     * [查詢] 分頁查詢 count
     * @author xieqi
     * @date 2019/10/18
     **/
    int pageListCount(int offset, int pagesize);

    /**
     * [查詢] 根据区域查询计划内容
     * @author xieqi
     * @date 2019/10/18
     **/
    List<Plan> findByArea(String area);


    /**
     * [查詢] 根据介质名称查询计划内容
     * @author xieqi
     * @date 2019/10/18
     **/
    List<Plan> findByMediaName(String mediaName);


    /**
     * [查詢] 查询所有计划内容
     * @author xieqi
     * @date 2019/10/18
     **/
    List<Plan> findAll();




}
