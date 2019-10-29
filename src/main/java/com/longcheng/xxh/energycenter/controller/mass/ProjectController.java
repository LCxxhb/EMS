package com.longcheng.xxh.energycenter.controller.mass;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.Media;
import com.longcheng.xxh.energycenter.entity.mass.Project;
import com.longcheng.xxh.energycenter.service.mass.MediaService;
import com.longcheng.xxh.energycenter.service.mass.ProjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * media
 * @author yangbo
 * @date 2019/10/28
 */
@RestController
@RequestMapping(value = "/Project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    /**
     * [新增]
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Results insert(Project project){
        return projectService.insert(project);
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
        return projectService.delete(id);
    }

    /**
     * [更新]
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Results update(Project project){
        return projectService.update(project);
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
        return projectService.load(id);
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
        return projectService.pageList(offset, pagesize);
    }

    /**
     * [查詢] 查询所有属性
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllProject",method = RequestMethod.POST)
    public Results findAllProject(){
        return projectService.findAllProject();
    }
}
