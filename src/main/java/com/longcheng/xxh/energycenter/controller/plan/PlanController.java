package com.longcheng.xxh.energycenter.controller.plan;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.plan.Plan;
import com.longcheng.xxh.energycenter.service.plan.PlanService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


/**
 * @author xieqi
 * @date 2019/11/05
 */
@RestController
@CrossOrigin(origins = "*")
@ResponseBody
@RequestMapping(value = "/plan",method = RequestMethod.POST)
public class PlanController {

    @Resource
    private PlanService planService;

    /**
     * [新增]
     * @author xieqi
     * @date 2019/11/05
     **/
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    @ResponseBody
    public String insert(Plan plan){ return JSON.toJSONString(planService.insert(plan));

    }

    /**
     * [刪除]
     * @author xieqi
     * @date 2019/11/05
     **/
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    @ResponseBody
    public String delete(int id){ return JSON.toJSONString(planService.delete(id));
    }

    /**
     * [更新]
     * @author xieqi
     * @date 2019/11/05
     **/
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    @ResponseBody
    public String update(Plan plan){
        return JSON.toJSONString(planService.update(plan));
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author xieqi
     * @date 2019/11/05
     **/
    @RequestMapping(value = "/load",method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    @ResponseBody
    public String load(int id){
        return JSON.toJSONString(planService.load(id));
    }

    /**
     * [查詢] 分頁查詢
     * @author xieqi
     * @date 2019/11/05
     **/
    @RequestMapping("/pageList")
    public Results pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "20") int pagesize) {
        return planService.pageList(offset, pagesize);
    }


    /**
     * [查詢] 查询所有计划
     * @author xieqi
     * @date 2019/10/18
     **/
    @CrossOrigin(origins = "*")
    @ResponseBody
    @RequestMapping(value ="/findAll",method = RequestMethod.POST)
    public String findAll(){
        return JSON.toJSONString(planService.findAll());
    }


}


