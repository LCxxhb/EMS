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
     * @param areaname
     * @param factory
     * @param tagtype
     * @param begintime
     * @param endtime
     * @param datatype
     * @return
     */
    @RequestMapping(value = "/history", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    @ResponseBody
    public String find_id(String areaname, String factory, String tagtype, String begintime, String endtime,String datatype) {
        String sql = null;
        String a = "SELECT A .AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A inner JOIN EMS_HIS_DATA_GAS B ON  A .COLLECTIONPOINT = B.COLLECTIONPOINT  ";
        String b = " where A.AREANAME = #{areaname} ";
        if (areaname != null&& areaname != ""){
            sql = a + b;
        }else {
            sql = a;
        }
        String c = "and A.BRANCHFACTORY = #{factory} ";
        if (factory != null&& factory != "")
            sql += c;
        String d = "and B.TAGTYPE = #{tagtype} ";
        if (tagtype != null&& tagtype != "")
            sql += d;
        String e = "and B.READTIME >= (select to_date(#{begintime},'yyyy-mm-dd,hh24:mi:ss') from dual )";
        if (begintime != null&& begintime != "")
            sql += e;
        String f = "and B.READTIME <= (select to_date(#{endtime},'yyyy-mm-dd,hh24:mi:ss') from dual )";
        if (endtime != null&& endtime != "")
            sql += f;
        String g = "and A.DATATYPE = #{datatype}";
        if (datatype != null&& datatype != "")
            sql += g;
        System.out.println(sql);
        List<Enti> list ;
        if (gasService.find_id(sql, areaname,factory,tagtype,begintime,endtime,datatype) == null){
            list = null;
        }else{
            list = gasService.find_id(sql, areaname,factory,tagtype,begintime,endtime,datatype);
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
    public String findParams(String datatype, String areaname, String factory, String tagtype) {
        String sql = null;
        String a = "SELECT * FROM EMS_HIS_DATA_GAS A INNER JOIN (SELECT DISTINCT COLLECTIONPOINT,MAX (READTIME) AS NEW_READTIME FROM EMS_HIS_DATA_GAS GROUP BY COLLECTIONPOINT) D ON A .COLLECTIONPOINT = D .COLLECTIONPOINT AND A .READTIME = D .NEW_READTIME INNER JOIN EMS_GAS_POINTCOLLECTION M ON D .COLLECTIONPOINT = M .COLLECTIONPOINT  ";
        String b = " where A.DATATYPE = #{datatype} ";
        if (datatype != null && datatype != ""){
            sql = a + b;
        }else {
            sql = a;
        }
        String c = "and M.AREANAME = #{areaname} ";
        if (areaname != null&& areaname != "")
            sql += c;
        String d = "and M.BRANCHFACTORY = #{param3} ";
        if (factory != null&& factory != "")
            sql += d;
        String e = "and A.TAGTYPE = #{tagtype}";
        if (tagtype != null&& tagtype != "")
            sql += e;
        System.out.println(sql);
        List<Enti> list ;
        if (gasService.findparams(sql, datatype,  areaname,  factory,  tagtype) == null){
            list = null;
        }else{
            list = gasService.findparams(sql, datatype,  areaname,  factory,  tagtype);
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
