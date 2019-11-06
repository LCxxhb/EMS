package com.longcheng.xxh.energycenter.controller.mass;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.MediaData;
import com.longcheng.xxh.energycenter.entity.mass.Unit;
import com.longcheng.xxh.energycenter.service.mass.MediaDataService;
import com.longcheng.xxh.energycenter.service.mass.UnitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * mediaData
 * @author yangbo
 * @date 2019/10/28
 */
@RestController
@RequestMapping(value = "/MediaData")
public class MediaDataController {

    @Resource
    private MediaDataService mediaDataService;

    /**
     * [新增]
     * @author yangbo
     * @date 2019/10/31
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Results insert(MediaData mediaData){
        return mediaDataService.insert(mediaData);
    }

    /**
     * [刪除]
     * @author yangbo
     * @date 2019/10/31
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    public Results delete(String id){
        return mediaDataService.delete(id);
    }

    /**
     * [更新]
     * @author yangbo
     * @date 2019/10/31
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Results update(MediaData mediaData){
        return mediaDataService.update(mediaData);
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author yangbo
     * @date 2019/10/31
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/load",method = RequestMethod.POST)
    public Results load(int id){
        return mediaDataService.load(id);
    }

    /**
     * [查詢] 分頁查詢
     * @author yangbo
     * @date 2019/10/31
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pageList",method = RequestMethod.POST)
    public Results pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return mediaDataService.pageList(offset, pagesize);
    }

    /**
     * [查詢] 查询所有单位
     * @author yangbo
     * @date 2019/10/31
     **/
    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllMediaData",method = RequestMethod.POST)
    public Results findAllMediaData(){
        return mediaDataService.findAllMediaData();
    }


    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByMidOrPidMediaData",method = RequestMethod.POST)
    public Results findByMidOrPidMediaData(int mid,int pid){
        return mediaDataService.findByMidOrPidMediaData(mid, pid);
    }
}
