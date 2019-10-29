package com.longcheng.xxh.energycenter.controller.mass;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.MediaOrProject;
import com.longcheng.xxh.energycenter.entity.mass.Project;
import com.longcheng.xxh.energycenter.service.mass.MediaOrProjectService;
import com.longcheng.xxh.energycenter.service.mass.ProjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * media
 * @author yangbo
 * @date 2019/10/28
 */
@RestController
@RequestMapping(value = "/MediaOrProject")
public class MediaOrProjectController {

    @Resource
    private MediaOrProjectService mediaOrProjectService;

    /**
     * [新增]
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Results insert(MediaOrProject mediaOrProject){
        return mediaOrProjectService.insert(mediaOrProject);
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
        return mediaOrProjectService.delete(id);
    }

    /**
     * [更新]
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Results update(MediaOrProject mediaOrProject){
        return mediaOrProjectService.update(mediaOrProject);
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
        return mediaOrProjectService.load(id);
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
        return mediaOrProjectService.pageList(offset, pagesize);
    }

    /**
     * [查詢] 查询所有配置
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllMediaOrProject",method = RequestMethod.POST)
    public Results findAllMediaOrProject(){
        return mediaOrProjectService.findAllMediaOrProject();
    }


    /**
     * [查詢] 通过介质id查询所有配置
     * @author yangbo
     * @date 2019/10/28
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByMidMediaOrProject",method = RequestMethod.POST)
    public Results findByMidMediaOrProject(String mid){
        return mediaOrProjectService.findByMidMediaOrProject(mid);
    }
}
