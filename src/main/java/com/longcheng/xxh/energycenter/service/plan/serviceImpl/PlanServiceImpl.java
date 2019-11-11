package com.longcheng.xxh.energycenter.service.plan.serviceImpl;


import com.longcheng.xxh.energycenter.dao.plan.PlanMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.plan.Plan;
import com.longcheng.xxh.energycenter.service.plan.PlanService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * plan
 *
 * @author xieqi
 * @date 2019/11/05
 */
@Service
public class PlanServiceImpl implements PlanService {

    @Resource
    private PlanMapper planMapper;

    @Override
    public Results insert(Plan plan) {
        String apiDesc = "添加计划接口";
        // valid参数校验
        plan.setUpdateBy("admin");
        plan.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        if (StringUtils.isEmpty(plan.getMediaName())) {
            return new Results(Code.param, "介质名称不能为空", "", apiDesc);
        } else if (StringUtils.isEmpty(plan.getArea())) {
            return new Results(Code.param, "区域不能为空", "", apiDesc);
        } else if (StringUtils.isEmpty(plan.getPlanTypeName())) {
            return new Results(Code.param, "计划类型名为空", "", apiDesc);
        } else {
            try {
                if (planMapper.insert(plan) > 0) {
                    return new Results(Code.success, "添加计划成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "添加计划失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results delete(String id) {

        String apiDesc = "删除用户接口";
        // valid
        if (StringUtils.isEmpty(id)) {
            return new Results(Code.param, "id为空!!", "", apiDesc);
        } else {
            try {
                String[] ids = id.split(",");
                int count = 0;
                for (int i = 0; i < ids.length; i++) {
                    planMapper.delete(ids[i]);
                    count++;
                }
                if (count > 0) {
                    return new Results(Code.success, "删除计划成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "删除计划失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results update(Plan plan) {
        String apiDesc = "修改计划接口";
        if (StringUtils.isEmpty(String.valueOf(plan.getId()))) {
            return new Results(Code.param, "计划id为空", "", apiDesc);
        } else {
            try {
                if (planMapper.update(plan) > 0) {
                    plan.setUpdateBy("admins");
                    plan.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    return new Results(Code.success, "编辑计划成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "编辑计划失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results load(int id) {
        String apiDesc = "根据id查询计划接口";
        // valid
        if (StringUtils.isEmpty(String.valueOf(id))) {
            return new Results(Code.param, "查询计划id为空!!", "", apiDesc);
        } else {
            try {
                Plan plan = planMapper.load(id);
                if (plan != null) {
                    return new Results(Code.success, "查询计划详情成功", plan, apiDesc);
                } else {
                    return new Results(Code.error, "查询计划详情失败", plan, apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results pageList(int offset, int pagesize) {
        List<Plan> pageList = planMapper.pageList(offset, pagesize);
        int totalCount = planMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return new Results();
    }

    @Override
    public Results findAll(Plan plan) {
        String apiDesc = "查所有计划接口";
        try {
            List<Plan> plans = planMapper.findAll(plan);
            if (CollectionUtils.isEmpty(plans)) {
                return new Results(Code.error, "没有查询到计划！", plans, apiDesc);
            } else {
                return new Results(Code.success, "查询所有计划成功", plans, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }
}
