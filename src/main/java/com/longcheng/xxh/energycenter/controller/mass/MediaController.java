package com.longcheng.xxh.energycenter.controller.mass;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.Media;
import com.longcheng.xxh.energycenter.service.mass.MediaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * media
 * @author yangbo
 * @date 2019/10/16
 */
@RestController
@RequestMapping(value = "/Media")
public class MediaController {

    @Resource
    private MediaService mediaService;

    /**
     * [新增]
     * @author yangbo
     * @date 2019/10/16
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Results insert(Media media){
        return mediaService.insert(media);
    }

    /**
     * [刪除]
     * @author yangbo
     * @date 2019/10/16
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    public Results delete(String id){
        return mediaService.delete(id);
    }

    /**
     * [更新]
     * @author yangbo
     * @date 2019/10/16
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Results update(Media media){
        return mediaService.update(media);
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author yangbo
     * @date 2019/10/16
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/load",method = RequestMethod.POST)
    public Results load(int id){
        return mediaService.load(id);
    }

    /**
     * [查詢] 分頁查詢
     * @author yangbo
     * @date 2019/10/16
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pageList",method = RequestMethod.POST)
    public Results pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return mediaService.pageList(offset, pagesize);
    }

    /**
     * [查詢] 查询所有介质
     * @author yangbo
     * @date 2019/10/24
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllMedia",method = RequestMethod.POST)
    public Results findAllMedia(){
        return mediaService.findAllMedia();
    }


    /**
     * [查詢] 根據pid查詢介质
     * @author yangbo
     * @date 2019/10/24
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByPidMedia",method = RequestMethod.POST)
    public Results findByPidMedia(String pid){
        return mediaService.findByPidMedia(pid);
    }

    /**
     * [查詢] 查詢一级介质
     * @author yangbo
     * @date 2019/10/24
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByOneMedia",method = RequestMethod.POST)
    public Results findByOneMedia(){
        return mediaService.findByOneMedia();
    }


    /**
     * [查詢] 查詢二级介质
     * @author yangbo
     * @date 2019/10/31
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByTwoMedia",method = RequestMethod.POST)
    public Results findByTwoMedia(){
        return mediaService.findByTwoMedia();
    }
}
