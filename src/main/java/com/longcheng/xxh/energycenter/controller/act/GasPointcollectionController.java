package com.longcheng.xxh.energycenter.controller.act;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.service.act.serviceImpl.GasPointcollectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/gaspoint")
public class GasPointcollectionController {

    @Autowired
    private GasPointcollectionServiceImpl gasPointcollectionService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam(value = "file", required = false) String path, HttpServletRequest request, HttpServletResponse response,String dataTable) {
        String result = gasPointcollectionService.upload(path, dataTable);
        return result;
    }



    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public String findAll() {
        List<Enti> regions = gasPointcollectionService.findAll();
        Results result = new Results(Code.success, "查询成功！！", regions, "查询所有采集点信息");
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findallareaname", method = RequestMethod.POST)
    public String findAllAreaname(String areaname) {
        List<Enti> regions = gasPointcollectionService.findAllPoint(areaname);
        Results result = new Results(Code.success, "查询成功！！", regions, "查询分厂所有数据信息");
        return JSON.toJSONString(result);
    }


    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/find_water", method = RequestMethod.POST)
    public String find_water(String areaname, String factory, String tagtype) {
        List<Enti> regions = gasPointcollectionService.find_water(areaname, factory, tagtype);
        Results result = new Results(Code.success, "查询成功！！", regions, "查询水介质信息");
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/find_gas", method = RequestMethod.POST)
    public String find_gas(String areaname, String factory, String tagtype) {
        List<Enti> regions = gasPointcollectionService.find_gas(areaname, factory, tagtype);
        Results result = new Results(Code.success, "查询成功！！", regions, "查询水介质信息");
        return JSON.toJSONString(result);
    }

}
