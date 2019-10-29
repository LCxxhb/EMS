package com.longcheng.xxh.energycenter.controller.sys;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.GasPointcollection;
import com.longcheng.xxh.energycenter.entity.sys.Water;
import com.longcheng.xxh.energycenter.service.sys.GasPointcollectionService;
import com.longcheng.xxh.energycenter.service.sys.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/water")
public class WaterController {
    @Autowired
    private WaterService waterService;
    @Autowired
    private GasPointcollectionService gasPointcollectionService;

    /**
     * 历史数据查询
     * mj
     *
     * @param param1
     * @param param2
     * @return
     */
    @RequestMapping(value = "/history", method = RequestMethod.POST)
    @ResponseBody
    public String find(String param1, String param2) {
        List<Water> gasList = waterService.find(param1, param2);
        for (int i = 0; i < gasList.size(); i++) {
            String point = gasList.get(i).getCollectionPoint();
            System.out.println(i);
        }
        return JSON.toJSONString(new Results(Code.success, "查询成功！！", waterService.find(param1, param2), "查询部分气体信息"));
    }

    /**
     * /** [查詢] 根据ID查询采集点信息
     *
     * @author mj
     */


    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public String load(String id) {
        if (id != null && id != "") {
            Water point = waterService.findById(Integer.parseInt(id));
            Results results = new Results(Code.success, "查询采集点信息成功", point, "通过id查询采集点信息");
            return JSON.toJSONString(results);
        } else {
            Results results = new Results(Code.error, "查询采集点信息失败！！", null, "通过id查询采集点信息");
            return JSON.toJSONString(results);
        }

    }

    /**
     * /** [查詢] 查询所有采集点信息
     *
     * @author mj
     **/

    @ResponseBody
    @RequestMapping(value = "/findAllPoint", method = RequestMethod.POST)
    public String findAllPoint() {
        List<Water> regions = waterService.findAllPoint();
        Results result = new Results(Code.success, "查询成功！！", regions, "查询所有采集点信息");
        return JSON.toJSONString(result);
    }


    /**
     * /** [查詢] 分頁查詢
     *
     * @author mj
     **/
    @ResponseBody
    @RequestMapping("/pageList")
    public String pageList(@RequestParam int count, @RequestParam int pagesize) {
        return JSON.toJSONString(new Results(Code.success, "查询成功！！", waterService.pageList(count, pagesize), "分页查询部分采集点信息"));
    }
}
