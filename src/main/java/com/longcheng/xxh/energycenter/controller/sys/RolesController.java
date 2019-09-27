package com.longcheng.xxh.energycenter.controller.sys;


import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Roles;
import com.longcheng.xxh.energycenter.service.sys.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/roles",method = RequestMethod.POST)
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findAllRoles",method = RequestMethod.POST)
    public String findAllRoles(HttpSession session){
        List<Roles> rolesList = rolesService.findAllRoles();
        Results results = new Results(Code.success,"查询所有角色成功",rolesList,"查询所有的角色信息");
        return JSON.toJSONString(results);
    }

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByIdRoles",method = RequestMethod.POST)
    public String findByIdRoles(String id,HttpSession session){
        if(id!=null&&id!=""){
            Roles roles = rolesService.findByAid(Integer.parseInt(id));
            Results results = new Results(Code.success,"查询角色成功",roles,"通过id查询角色信息");
            return JSON.toJSONString(results);
        }else {
            Results results = new Results(Code.error,"查询角色失败！！", null,"通过id查询角色信息");
            return JSON.toJSONString(results);
        }
    }

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/addRoles",method = RequestMethod.POST)
    public String addRoles(Roles roles, HttpSession session){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        roles.setCreateDate(dateFormat.format(date));
        roles.setCreateBy("admin");
        Boolean b = rolesService.addRoles(roles);
        if(b){
            Results result = new Results(Code.success,"添加成功！！", null,"添加角色信息");
            return JSON.toJSONString(result);
        }else {
            Results result = new Results(Code.error,"添加失败！！", null,"添加角色信息");
            return JSON.toJSONString(result);
        }
    }


    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/updateRoles",method = RequestMethod.POST)
    public String updateRoles(Roles roles, HttpSession session){
        if(roles.getId().toString()!=null&&roles.getId().toString()!=""){
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            roles.setLastUpdateDate(dateFormat.format(date));
            roles.setLastUpdateBy("admin");
            roles.setCreateDate(rolesService.findByAid(Integer.parseInt(roles.getId()+"")).getCreateDate());
            roles.setCreateBy(rolesService.findByAid(Integer.parseInt(roles.getId()+"")).getCreateBy());
            Boolean b = rolesService.updateRoles(roles);
            if(b){
                Results result = new Results(Code.success,"修改成功！！", null,"修改角色信息");
                return JSON.toJSONString(result);
            }else {
                Results result = new Results(Code.error,"修改失败！！", null,"修改角色信息");
                return JSON.toJSONString(result);
            }
        }else {
            Results result = new Results(Code.param,"参数验证失败！！", null,"修改角色信息");
            return JSON.toJSONString(result);
        }
    }

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/deleteRoles",method = RequestMethod.POST)
    public String deleteRoles(String id,HttpSession session){
        if(id!=null&&id!=""){
            String[] strings = id.split(",");
            Boolean b = rolesService.deleteRoles(strings);
            if(b){
                Results result = new Results(Code.success,"删除成功！！", null,"通过id删除角色信息");
                return JSON.toJSONString(result);
            }else {
                Results result = new Results(Code.error,"删除失败！！", null,"通过id删除角色信息");
                return JSON.toJSONString(result);
            }
        }else {
            Results result = new Results(Code.param,"删除失败！！aid不能为空！！", null,"通过id删除角色信息");
            return JSON.toJSONString(result);
        }
    }
}
