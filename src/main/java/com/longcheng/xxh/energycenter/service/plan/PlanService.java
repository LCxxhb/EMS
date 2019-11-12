package com.longcheng.xxh.energycenter.service.plan;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.plan.Plan;


/**
 * plan
 * @author xieqi
 * @date 2019/11/05
 */
public interface PlanService {

    /**
     * 新增
     */
    public Results insert(Plan plan);

    /**
     * 删除
     */
    public Results delete(String id);

    /**
     * 更新
     */
    public Results update(Plan plan);

    /**
     * 根據主鍵 id 查詢
     */
    public Results load(int id);

    /**
     * 分页查询
     */
    public Results pageList(int offset, int pagesize);

    /**
     * 查询所有计划内容
     */
    public Results findAll(Plan plan);


}



