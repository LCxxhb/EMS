package com.longcheng.xxh.energycenter.controller.sys;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.sys.Region;
import com.longcheng.xxh.energycenter.service.sys.RegionService;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/region",method = RequestMethod.POST)
public class RegionController {

    @Autowired
    private RegionService regionService;

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllRegion",method = RequestMethod.POST)
    public String findAllRegion(HttpSession session){
        List<Region> regions = regionService.findAllRegion();
        Result result =  new Result(Code.success,"查询成功！！",regions,"查询一级分类信息");
        return JSON.toJSONString(result);
    }
    /*public Result findAllRegion(HttpSession session){
        List<Region> regions = regionService.findAllRegion();
        return new Result(Code.success,"查询成功！！",JsonUtils.objectToJson(regions),"查询一级分类信息");
    }*/

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByAid",method = RequestMethod.POST)
    public String  findByAid(String aid,HttpSession session){
        if (aid!=""&&aid!=null){
            List<Region> regions = regionService.findByAid(Integer.parseInt(aid));
            Result result = new Result(Code.success,"查询成功！！", regions,"通过Aid查询区域信息");
            return JSON.toJSONString(result);
        }else {
            Result result = new Result(Code.error,"查询失败！！", null,"通过Aid查询区域信息");
            return JSON.toJSONString(result);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/findByPid",method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public String findByPid(String pid,HttpSession session, ModelAndView modelAndView){
        if(pid!=null&&pid!=""){
            List<Region> regions = regionService.findByPid(Integer.parseInt(pid));
            Result result =  new Result(Code.success,"查询成功！！", regions,"通过Pid查询区域信息");
            return JSON.toJSONString(result);
        }else {
            Result result = new Result(Code.error,"查询失败！！Pid不能为空！！", null,"通过Pid查询区域信息");
            return JSON.toJSONString(result);
        }

    }

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/addRegion",method = RequestMethod.POST)
    public String  addRegion(Region region,HttpSession session){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        region.setCreatedate(dateFormat.format(date));
        region.setAid(new BigDecimal(region.getPid()));
        Boolean b = regionService.addRegion(region);
        if(b){
            Result result = new Result(Code.success,"添加成功！！", null,"添加区域信息");
            return JSON.toJSONString(result);
        }else {
            Result result = new Result(Code.error,"添加失败！！", null,"添加区域信息");
            return JSON.toJSONString(result);
        }
    }

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/updateRegion",method = RequestMethod.POST)
    public String updateRegion(Region region,HttpSession session, ModelAndView modelAndView){
        Boolean b = regionService.updateRegion(region);
        if(b){
            Result result = new Result(Code.success,"修改成功！！", null,"修改区域信息");
            return JSON.toJSONString(result);
        }else {
            Result result = new Result(Code.error,"修改失败！！", null,"修改区域信息");
            return JSON.toJSONString(result);
        }
    }

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/deleteRegion",method = RequestMethod.POST)
    public String  deleteRegion(String aid,HttpSession session){
        if(aid!=null&&aid!=""){
            Boolean b = regionService.deleteRegion(Integer.parseInt(aid));
            if(b){
                Result result = new Result(Code.success,"删除成功！！", null,"删除区域信息");
                return JSON.toJSONString(result);
            }else {
                Result result = new Result(Code.error,"删除失败！！", null,"删除区域信息");
                return JSON.toJSONString(result);
            }
        }else {
            Result result = new Result(Code.error,"删除失败！！aid不能为空！！", null,"删除区域信息");
            return JSON.toJSONString(result);
        }

    }

}
