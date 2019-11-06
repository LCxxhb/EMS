package com.longcheng.xxh.energycenter.service.plan;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.plan.Plan;

import java.util.List;
import java.util.Map;

/**
 * MenuService
 *
 * @author xieqi
 * @date 2019/10/10
 */
public interface PlanService {

    /**
     * 新增
     */
    public Results  add(Plan plan);

    /**
     * 删除
     */
    public Results delete(int id);

    /**
     * 更新
     */
    public Results update(Plan plan);

    /**
     * 根據主鍵 id 查詢
     */
    public Plan findById(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);

    /**
     * 根據区域名称查詢计划信息
     */
    public List<Plan> findByArea(String area);

    /**
     * 根據介质名称查詢计划信息
     */
    public List<Plan> findByMediaName(String mediaName);

    /**
     * 根據介质名称查詢计划信息
     */
    public List<Plan> findAll();



}
