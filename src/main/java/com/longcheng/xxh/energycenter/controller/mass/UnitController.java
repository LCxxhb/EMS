package com.longcheng.xxh.energycenter.controller.mass;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.Project;
import com.longcheng.xxh.energycenter.entity.mass.Unit;
import com.longcheng.xxh.energycenter.service.mass.ProjectService;
import com.longcheng.xxh.energycenter.service.mass.UnitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * media
 * @author yangbo
 * @date 2019/10/28
 */
@RestController
@RequestMapping(value = "/Unit")
public class UnitController {

    @Resource
    private UnitService unitService;

    /**
     * [新增]
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Results insert(Unit unit){
        return unitService.insert(unit);
    }

    /**
     * [刪除]
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    public Results delete(String id){
        return unitService.delete(id);
    }

    /**
     * [更新]
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Results update(Unit unit){
        return unitService.update(unit);
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/load",method = RequestMethod.POST)
    public Results load(int id){
        return unitService.load(id);
    }

    /**
     * [查詢] 分頁查詢
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pageList",method = RequestMethod.POST)
    public Results pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return unitService.pageList(offset, pagesize);
    }

    /**
     * [查詢] 查询所有单位
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllUnit",method = RequestMethod.POST)
    public Results findAllUnit(){
        return unitService.findAllUnit();
    }
}
