package com.longcheng.xxh.energycenter.controller.sys;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Region;
import com.longcheng.xxh.energycenter.entity.sys.RegionExtend;
import com.longcheng.xxh.energycenter.service.sys.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/region", method = RequestMethod.POST)
public class RegionController {

    @Autowired
    private RegionService regionService;


    @PostMapping(value = "/findAllRegion", produces = "text/html;charset=UTF-8")
    public String findAllRegion(HttpSession session) {
        List<RegionExtend> regionExtends = regionService.findAllRegionExtend();
        Results result = new Results(Code.success, "查询成功！！", regionExtends, "查询所有区域信息");
        return JSON.toJSONString(result);
    }


    @PostMapping(value = "/findByAid", produces = "text/html;charset=UTF-8")
    public String findByAid(String aid, HttpSession session) {
        if (aid != "" && aid != null) {
            List<Region> regions = regionService.findByAid(Integer.parseInt(aid));
            Results result = new Results(Code.success, "查询成功！！", regions, "通过Aid查询区域信息");
            return JSON.toJSONString(result);
        } else {
            Results result = new Results(Code.error, "查询失败！！", null, "通过Aid查询区域信息");
            return JSON.toJSONString(result);
        }

    }


    @PostMapping(value = "/findByPid", produces = "text/html;charset=UTF-8")
    public String findByPid(String pid) {
        if (pid != null && pid != "") {
            List<RegionExtend> regions = regionService.findByPid(Integer.parseInt(pid));
            Results result = new Results(Code.success, "查询成功！！", regions, "通过Pid查询区域信息");
            return JSON.toJSONString(result);
        } else {
            Results result = new Results(Code.error, "查询失败！！Pid不能为空！！", null, "通过Pid查询区域信息");
            return JSON.toJSONString(result);
        }

    }


    @PostMapping(value = "/findByPidRegion", produces = "text/html;charset=UTF-8")
    public String findByPidRegion(String pid) {
        if (pid != null && pid != "") {
            List<Region> regions = regionService.findByPidRegion(Integer.parseInt(pid));
            Results result = new Results(Code.success, "查询成功！！", regions, "通过Pid查询区域信息");
            return JSON.toJSONString(result);
        } else {
            Results result = new Results(Code.error, "查询失败！！Pid不能为空！！", null, "通过Pid查询区域信息");
            return JSON.toJSONString(result);
        }

    }

    @PostMapping(value = "/addRegion", produces = "text/html;charset=UTF-8")
    public String addRegion(Region region, HttpSession session) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        region.setCreatedate(dateFormat.format(date));
        region.setAid(new BigDecimal(region.getPid()));
        region.setCreateby("admin");
        region.setLastupdateby("admin");
        region.setLastupdatedate(dateFormat.format(date));
        Boolean b = regionService.addRegion(region);
        if (b) {
            Results result = new Results(Code.success, "添加成功！！", null, "添加区域信息");
            return JSON.toJSONString(result);
        } else {
            Results result = new Results(Code.error, "添加失败！！", null, "添加区域信息");
            return JSON.toJSONString(result);
        }
    }


    @PostMapping(value = "/updateRegion", produces = "text/html;charset=UTF-8")
    public String updateRegion(Region region, HttpSession session) {
        List<Region> regions = new ArrayList<Region>();
        if (region.getAid() != null && region.getAname() != null && region.getAname() != "") {
            regions = regionService.findByAid(Integer.parseInt(region.getAid() + ""));
        }
        region.setCreatedate(regions.get(0).getCreatedate());
        region.setCreateby(regions.get(0).getCreateby());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        region.setLastupdatedate(simpleDateFormat.format(date));
        region.setLastupdateby("damin");
        Boolean b = regionService.updateRegion(region);
        if (b) {
            Results result = new Results(Code.success, "修改成功！！", null, "修改区域信息");
            return JSON.toJSONString(result);
        } else {
            Results result = new Results(Code.error, "修改失败！！", null, "修改区域信息");
            return JSON.toJSONString(result);
        }
    }


    @PostMapping(value = "/deleteRegion", produces = "text/html;charset=UTF-8")
    public String deleteRegion(String aid, HttpSession session) {
        if (aid != null && aid != "") {
            String[] strings = aid.split(",");
            Boolean b = regionService.deleteRegion(strings);
            if (b) {
                Results result = new Results(Code.success, "删除成功！！", null, "删除区域信息");
                return JSON.toJSONString(result);
            } else {
                Results result = new Results(Code.error, "删除失败！！", null, "删除区域信息");
                return JSON.toJSONString(result);
            }
        } else {
            Results result = new Results(Code.error, "删除失败！！aid不能为空！！", null, "删除区域信息");
            return JSON.toJSONString(result);
        }
    }


    @PostMapping(value = "/findByOneTwoRegion", produces = "text/html;charset=UTF-8")
    public String findByOneTwoRegion(HttpSession session) {
        List<Region> regions = regionService.findByOneTwoRegion();
        Results result = new Results(Code.success, "查询一二级区域成功！！", regions, "查询一二级区域信息");
        return JSON.toJSONString(result);
    }


    @PostMapping(value = "/findByTwoRegion", produces = "text/html;charset=UTF-8")
    public String findByTwoRegion(HttpSession session) {
        List<Region> regions = regionService.findByTwoRegion();
        Results result = new Results(Code.success, "查询二级区域成功！！", regions, "查询二级区域信息");
        return JSON.toJSONString(result);
    }

}
