package com.longcheng.xxh.energycenter.controller.plan;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.plan.Plan;
import com.longcheng.xxh.energycenter.service.plan.PlanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * plan
 * @author xieqi
 * @date 2019/10/18
 */
@RestController
@RequestMapping(value = "/plan")
public class PlanController {

    @Resource
    private PlanService planService;

    /**
     * [新增]
     * @author xieqi
     * @date 2019/10/18
     **/
    @RequestMapping("/add")
    public Results add(Plan plan){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        plan.setCreateBy("admin");
        plan.setCreateDate(dateFormat.format(date));
        return  planService.add(plan);
    }

    /**
     * [刪除]
     * @author xieqi
     * @date 2019/10/18
     **/
    @RequestMapping("/delete")
    public Results delete(int id){ return planService.delete(id);

    }

    /**
     * [更新]
     * @author xieqi
     * @date 2019/10/18
     **/
    @RequestMapping("/update")
    public Results update(Plan plan){ return  planService.update(plan);

    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author xieqi
     * @date 2019/10/18
     *
     * @return*/

    @RequestMapping("/findById")
    public String findById(int id){
        Plan plan = planService.findById(id);
        Results results = new Results(Code.success, "根据ID查询计划内容成功", plan, "通过ID查询计划内容");
        return JSON.toJSONString(results);
    }


    /**
     * [查詢] 分頁查詢
     * @author xieqi
     * @date 2019/10/18
     **/
    @RequestMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "20") int pagesize) {
        return planService.pageList(offset, pagesize);
    }


    /**
     * [查詢] 根据区域查詢计划内容
     * @author xieqi
     * @date 2019/10/18
     **/
    @RequestMapping("/findByArea")
    public String findByArea(String area){
        List<Plan> plan =planService.findByArea(area);
        if(area != null && area != ""){
            Results results = new Results(Code.success, "查询计划内容成功", plan, "通过区域查询计划内容");
            return JSON.toJSONString(results);
        }else{
            Results results = new Results(Code.success, "查询计划内容失败", null, "通过区域查询计划内容");
            return JSON.toJSONString(results);
        }
    }



    /**
     * [查詢] 根据介质名查询计划内容
     * @author xieqi
     * @date 2019/10/18
     **/
    @RequestMapping("/findByMediaName")
    public String findByMediaName(String mediaName){
        List<Plan> plan =planService.findByMediaName(mediaName);
        if(mediaName != null && mediaName != ""){
            Results results = new Results(Code.success, "查询计划内容成功",plan, "通过介质名称查询计划内容");
            return JSON.toJSONString(results);
        }else{
            Results results = new Results(Code.success, "查询计划内容失败", null, "通过介质名称查询计划内容");
            return JSON.toJSONString(results);
        }

    }


    /**
     * [查詢] 查询所有计划
     * @author xieqi
     * @date 2019/10/18
     **/
    @RequestMapping("/findAll")
    public String findAll(){
        List<Plan> plan =planService.findAll();
        Results results = new Results(Code.success, "根据介质类型查询计划内容", plan, "根据介质类型查询计划内容");
        return JSON.toJSONString(results);
    }


}

