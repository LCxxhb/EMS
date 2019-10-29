package com.longcheng.xxh.energycenter.controller.sys;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Point;
import com.longcheng.xxh.energycenter.service.sys.PointService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/point",method = RequestMethod.POST)
public class PointController {
    @Resource
    private PointService pointService;

        /**
         /** [查詢] 根据ID查询采集点信息
        * @author xieqi
        * @date 2019/09/28
        * */

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public String load(String id, HttpSession session) {
        if (id != null && id != "") {
            Point point = pointService.findById(Integer.parseInt(id));
            Results results = new Results(Code.success, "查询采集点信息成功", point, "通过id查询采集点信息");
            return JSON.toJSONString(results);
        } else {
            Results results = new Results(Code.error, "查询采集点信息失败！！", null, "通过id查询采集点信息");
            return JSON.toJSONString(results);
        }

    }

        /**
         /** [查詢] 查询所有采集点信息
         * @author xieqi
         * @date 2019/09/28
         **/

        @ResponseBody
        @CrossOrigin(origins = "*")
        @RequestMapping(value = "/findAllPoint",method = RequestMethod.POST)
        public String findAllPoint(HttpSession session){
            List<Point> points = pointService.findAllPoint();
            Results result =  new Results(Code.success,"查询成功！！",points,"查询所有采集点信息");
            return JSON.toJSONString(result);
        }



        /**
         /** [查詢] 分頁查詢
         * @author xieqi
         * @date 2019/09/28
         **/
        @ResponseBody
        @RequestMapping("/pageList")
        public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                            @RequestParam(required = false, defaultValue = "20") int pagesize) {
            return (Map<String, Object>) pointService.pageList(offset, pagesize);
        }


    /**
     /** [查詢] 根据区域查询采集点
     **/
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByAreaname", method = RequestMethod.POST)
    @ResponseBody
    public String findByAreaname(String areaname, HttpSession session) {

        if (areaname != null && areaname!= "") {
            List<Point> points = pointService.findByAreaname(areaname);
            Results results = new Results(Code.success, "查询采集点信息成功", points, "通过区域查询采集点信息");
            return JSON.toJSONString(results);
        } else {
            Results results = new Results(Code.error, "查询采集点信息失败！！", null, "通过区域查询采集点信息");
            return JSON.toJSONString(results);
        }

    }


    /**
     /** [查詢] 根据分厂查询采集点
     **/
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByBranchfactory", method = RequestMethod.POST)
    @ResponseBody
    public String findByBranchfactory(String branchfactory, HttpSession session) {
        if (branchfactory != null && branchfactory!= "") {
            List<Point> points = pointService.findByBranchfactory(branchfactory);
            Results results = new Results(Code.success, "查询采集点信息成功", points, "通过分厂查询采集点信息");
            return JSON.toJSONString(results);
        } else {
            Results results = new Results(Code.error, "查询采集点信息失败！！", null, "通过分厂查询采集点信息");
            return JSON.toJSONString(results);
        }

    }
}
