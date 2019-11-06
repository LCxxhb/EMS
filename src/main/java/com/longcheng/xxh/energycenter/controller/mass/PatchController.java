package com.longcheng.xxh.energycenter.controller.mass;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.Patch;
import com.longcheng.xxh.energycenter.entity.mass.Unit;
import com.longcheng.xxh.energycenter.service.mass.PatchService;
import com.longcheng.xxh.energycenter.service.mass.UnitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * patch
 * @author yangbo
 * @date 2019/10/31
 */
@RestController
@RequestMapping(value = "/Patch")
public class PatchController {

    @Resource
    private PatchService patchService;

    /**
     * [新增]
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Results insert(Patch patch){
        return patchService.insert(patch);
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
        return patchService.delete(id);
    }

    /**
     * [更新]
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Results update(Patch patch){
        return patchService.update(patch);
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
        return patchService.load(id);
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
        return patchService.pageList(offset, pagesize);
    }

    /**
     * [查詢] 查询所有单位
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllPatch",method = RequestMethod.POST)
    public Results findAllPatch(){
        return patchService.findAllPatch();
    }
}
