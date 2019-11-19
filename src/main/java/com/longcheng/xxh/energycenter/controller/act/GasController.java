package com.longcheng.xxh.energycenter.controller.act;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.service.act.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/gas")
public class GasController {
    @Autowired
    private GasService gasService;


    /**
     * 不定参数历史数据查询
     * @param param1
     * @param param2
     * @param param3
     * @param param4
     * @param param5
     * @return
     */
    @RequestMapping(value = "/history", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    @ResponseBody
    public String find_id(String param1, String param2, String param3, String param4, String param5,String param6) {
        String sql = null;
        String a = "SELECT A .AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A inner JOIN EMS_HIS_DATA_GAS B ON  A .COLLECTIONPOINT = B.COLLECTIONPOINT  ";
        String b = " where A.AREANAME = #{param1} ";
        if (param1 != null&& param1 != ""){
            sql = a + b;
        }else {
            sql = a;
        }
        String c = "and A.BRANCHFACTORY = #{param2} ";
        if (param2 != null&& param2 != "")
            sql += c;
        String d = "and B.TAGTYPE = #{param3} ";
        if (param3 != null&& param3 != "")
            sql += d;
        String e = "and B.READTIME >= (select to_date(#{param4},'yyyy-mm-dd,hh24:mi:ss') from dual )";
        if (param4 != null&& param4 != "")
            sql += e;
        String f = "and B.READTIME <= (select to_date(#{param5},'yyyy-mm-dd,hh24:mi:ss') from dual )";
        if (param5 != null&& param5 != "")
            sql += f;
        String g = "and A.DATATYPE = #{param6}";
        if (param6 != null&& param6 != "")
            sql += g;
        System.out.println(sql);
        List<Enti> list ;
        if (gasService.find_id(sql, param1, param2, param3, param4, param5,param6) == null){
            list = null;
        }else{
            list = gasService.find_id(sql, param1, param2, param3, param4, param5,param6);
        }
            return JSON.toJSONString(new Results(Code.success, "查询成功！！", list, "查询部分气体介质信息"));
    }


 /*   *//**
     * /** [查詢] 根据ID查询采集点信息
     *
     * @author mj
     *//*


    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public String load(String id) {
        if (id != null && id != "") {
            Enti point = gasService.findById(Integer.parseInt(id));
            System.out.println(point.toString());
            Results results = new Results(Code.success, "查询采集点信息成功", point, "通过id查询采集点信息");
            return JSON.toJSONString(results);

        } else {
            Results results = new Results(Code.error, "查询采集点信息失败！！", null, "通过id查询采集点信息");
            return JSON.toJSONString(results);

        }

    }*/

    /**
     * /** [查詢] 历史查询所有采集点信息
     *
     * @author mj
     **/

    @ResponseBody
    @RequestMapping(value = "/findAllHistory", method = RequestMethod.POST)
    public String findAllPoint() {
        List<Enti> regions = gasService.findAllPoint();
        Results result = new Results(Code.success, "查询成功！！", regions, "查询所有采集点气体信息");
        return JSON.toJSONString(result);
    }


    /**
     * /** [查詢] 分頁查詢
     *
     * @author mj
     **/
    @ResponseBody
    @RequestMapping("/pageList")
    public String pageList(@RequestParam(required = false, defaultValue = "0") int count,
                           @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return JSON.toJSONString(new Results(Code.success, "查询成功！！", gasService.pageList(count, pagesize), "分页查询部分采集点气体信息"));
    }


    /**
     * /** [查詢] 实时查询所有气体信息
     *
     * @author mj
     **/

    @ResponseBody
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public String findAll() {
        List<Enti> regions = gasService.findAll();
        Results result = new Results(Code.success, "查询成功！！", regions, "实时查询所有气体信息");
        return JSON.toJSONString(result);
    }
    @RequestMapping(value = "/diately", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    @ResponseBody
    public String findParams(String param1, String param2, String param3, String param4) {
        String sql = null;
        String a = "SELECT * FROM EMS_HIS_DATA_GAS A INNER JOIN (SELECT DISTINCT COLLECTIONPOINT,MAX (READTIME) AS NEW_READTIME FROM EMS_HIS_DATA_GAS GROUP BY COLLECTIONPOINT) D ON A .COLLECTIONPOINT = D .COLLECTIONPOINT AND A .READTIME = D .NEW_READTIME INNER JOIN EMS_GAS_POINTCOLLECTION M ON D .COLLECTIONPOINT = M .COLLECTIONPOINT  ";
        String b = " where A.DATATYPE = #{param1} ";
        if (param1 != null && param1 != ""){
            sql = a + b;
        }else {
            sql = a;
        }
        String c = "and M.AREANAME = #{param2} ";
        if (param2 != null&& param2 != "")
            sql += c;
        String d = "and M.BRANCHFACTORY = #{param3} ";
        if (param3 != null&& param3 != "")
            sql += d;
        String e = "and A.TAGTYPE = #{param4}";
        if (param4 != null&& param4 != "")
            sql += e;
        System.out.println(sql);
        List<Enti> list ;
        if (gasService.findparams(sql, param1, param2, param3, param4) == null){
            list = null;
        }else{
            list = gasService.findparams(sql, param1, param2, param3, param4);
        }
        return JSON.toJSONString(new Results(Code.success, "查询成功！！", list, "查询部分气体介质信息"));
    }

//    /**
//     * /** [查詢] 实时查询某种气体信息
//     *
//     * @author mj
//     **/
//
//    @ResponseBody
//    @RequestMapping(value = "/findAllTagtype", method = RequestMethod.POST)
//    public String findAllMedium(String tagtype) {
//        List<Enti> regions = gasService.findallmedium(tagtype);
//        Results result = new Results(Code.success, "查询成功！！", regions, "实时查询所有气体介质信息");
//        return JSON.toJSONString(result);
//    }
//    /**
//     * /** [查詢] 实时查询某分厂信息
//     *
//     * @author mj
//     **/
//
//    @ResponseBody
//    @RequestMapping(value = "/findAllAreaname", method = RequestMethod.POST)
//    public String findAllAreaname(String areaname) {
//        List<Enti> regions = gasService.findallareaname(areaname);
//        Results result = new Results(Code.success, "查询成功！！", regions, "实时查询某分厂气体信息");
//        return JSON.toJSONString(result);
//    }
//    /**
//     * /** [查詢] 实时查询某区域信息
//     *
//     * @author mj
//     **/
//
//    @ResponseBody
//    @RequestMapping(value = "/findAllFactory", method = RequestMethod.POST)
//    public String findAllFactory(String factory) {
//        List<Enti> regions = gasService.findallfactory(factory);
//        Results result = new Results(Code.success, "查询成功！！", regions, "实时查询某区域气体信息");
//        return JSON.toJSONString(result);
//    }
//
//    /**
//     * /** [查詢] 实时查询某采集点信息
//     *
//     * @author mj
//     **/
//
//    @ResponseBody
//    @RequestMapping(value = "/findAllPoint", method = RequestMethod.POST)
//    public String findAllPoint(String point) {
//        List<Enti> regions = gasService.findallpoint(point);
//        Results result = new Results(Code.success, "查询成功！！", regions, "实时查询某采集点气体信息");
//        return JSON.toJSONString(result);
//    }

}
