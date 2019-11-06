package com.longcheng.xxh.energycenter.service.plan.serviceImpl;

import com.longcheng.xxh.energycenter.dao.plan.PlanMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.plan.Plan;
import com.longcheng.xxh.energycenter.service.plan.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
;

/**
 * roles
 *
 * @author xieqi
 * @date 2019/10/10
 */
@Service
public class PlanServiceImpl implements PlanService {

    @Resource
    private PlanMapper planMapper;


    @Override
    public Results add(Plan plan) {
        planMapper.add(plan);
        return new Results();
    }


    @Override
    public Results delete(int id) {
        int ret = planMapper.delete(id);
        return new Results();
    }


    @Override
    public Results update(Plan plan) {
        int ret = planMapper.update(plan);
        return new Results();
    }


    @Override
    public Plan findById(int id) {
        return planMapper.findById(id);
    }


    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {

        List<Plan> pageList = planMapper.pageList(offset, pagesize);
        int totalCount = planMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }



    @Override
    public List<Plan> findByArea(String area) {
        List<Plan> plans = planMapper.findByArea(area);
        return plans;
    }



    @Override
    public List<Plan> findByMediaName(String mediaName) {
        List<Plan> plans = planMapper.findByMediaName(mediaName);
        return  plans;
    }



    @Override
    public List<Plan> findAll() {
        List<Plan> plans = planMapper.findAll();
        return plans;
    }

}
