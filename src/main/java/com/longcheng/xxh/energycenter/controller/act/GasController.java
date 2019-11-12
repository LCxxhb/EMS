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
    public String find_id(String param1, String param2, String param3, String param4, String param5) {
        String sql = null;
        String a = "SELECT A .AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A inner JOIN EMS_HIS_DATA_GAS B ON  A .COLLECTIONPOINT = B.COLLECTIONPOINT where ";
        String b = "A.AREANAME = #{param1} ";
        if (param1 != null)
            sql = a + b;
        String c = "and A.BRANCHFACTORY = #{param2} ";
        if (param2 != null)
            sql += c;
        String d = "and B.TAGTYPE = #{param3} ";
        if (param3 != null)
            sql += d;
        String e = "and B.READTIME >= (select to_date(#{param4},'yyyy-mm-dd,hh24:mi:ss') from dual )";
        if (param4 != null)
            sql += e;
        String f = "and B.READTIME <= (select to_date(#{param5},'yyyy-mm-dd,hh24:mi:ss') from dual )";
        if (param5 != null)
            sql += f;
      /*  String g = " ORDER BY to_number(B.TAGVAL)";
        sql += g;*/
        System.out.println(sql);
        return JSON.toJSONString(new Results(Code.success, "查询成功！！", gasService.find_id(sql, param1, param2, param3, param4, param5), "查询部分气体介质信息"));
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
            Enti point = gasService.findById(Integer.parseInt(id));
            System.out.println(point.toString());
            Results results = new Results(Code.success, "查询采集点信息成功", point, "通过id查询采集点信息");
            return JSON.toJSONString(results);

        } else {
            Results results = new Results(Code.error, "查询采集点信息失败！！", null, "通过id查询采集点信息");
            return JSON.toJSONString(results);

        }

    }

    /**
     * /** [查詢] 历史查询所有采集点信息
     *
     * @author mj
     **/

    @ResponseBody
    @RequestMapping(value = "/findAllPoint", method = RequestMethod.POST)
    public String findAllPoint() {
        List<Enti> regions = gasService.findAllPoint();
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
    public String pageList(@RequestParam(required = false, defaultValue = "0") int count,
                           @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return JSON.toJSONString(new Results(Code.success, "查询成功！！", gasService.pageList(count, pagesize), "分页查询部分采集点信息"));
    }


    /**
     * /** [查詢] 实时查询所有采集点信息
     *
     * @author mj
     **/

    @ResponseBody
    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public String findAll() {
        List<Enti> regions = gasService.findAll();
        Results result = new Results(Code.success, "查询成功！！", regions, "查询所有采集点信息");
        return JSON.toJSONString(result);
    }

}
