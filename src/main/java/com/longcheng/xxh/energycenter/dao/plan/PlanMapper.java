package com.longcheng.xxh.energycenter.dao.plan;

import com.longcheng.xxh.energycenter.entity.plan.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * plan
 *
 * @author xieqi
 * @date 2019/11/08
 */
@Mapper
@Repository
public interface PlanMapper {

    /**
     * [新增]
     *
     * @author xieqi
     * @date 2019/11/08
     **/
    int insert(Plan plan);

    /**
     * [刪除]
     *
     * @author xieqi
     * @date 2019/11/08
     **/
    int delete(String id);

    /**
     * [更新]
     *
     * @author xieqi
     * @date 2019/11/08
     **/
    int update(Plan plan);

    /**
     * [查詢] 根據主鍵 id 查詢
     *
     * @author xieqi
     * @date 2019/11/08
     **/
    Plan load(int id);
    /**
     * [查詢] 根据搜索条件查询
     *
     * @author xieqi
     * @date 2019/11/08
     **/
    List<Plan> findAll(Plan plan);
    /**
     * [查詢] 分頁查詢
     *
     * @author xieqi
     * @date 2019/11/08
     **/
    List<Plan> pageList(int offset, int pagesize);

    /**
     * [查詢] 分頁查詢 count
     *
     * @author xieqi
     * @date 2019/11/08
     **/
    int pageListCount(int offset, int pagesize);

}
