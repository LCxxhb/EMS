package com.longcheng.xxh.energycenter.dao.plan;

import com.longcheng.xxh.energycenter.entity.plan.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * ems_energy_plan
 * @author xieqi
 * @date 2019/11/05
 */
@Mapper
@Repository
public interface PlanMapper {

    /**
     * [新增]
     * @author xieqi
     * @date 2019/11/05
     **/
    int insert(Plan Plan);

    /**
     * [刪除]
     * @author xieqi
     * @date 2019/11/05
     **/
    int delete(int id);

    /**
     * [更新]
     * @author xieqi
     * @date 2019/11/05
     **/
    int update(Plan Plan);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author xieqi
     * @date 2019/11/05
     **/
    Plan load(int id);

    /**
     * [查詢] 分頁查詢
     * @author xieqi
     * @date 2019/11/05
     **/
    List<Plan> pageList(int offset,int pagesize);

    /**
     * [查詢] 分頁查詢 count
     * @author xieqi
     * @date 2019/11/05
     **/
    int pageListCount(int offset,int pagesize);


    /**
     * [查詢] 查询所有计划内容
     * @author xieqi
     * @date 2019/10/18
     **/
    List<Plan> findAll();




}
