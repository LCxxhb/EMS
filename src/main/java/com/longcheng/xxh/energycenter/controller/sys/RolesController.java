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
    public String findByIdRoles(int id,HttpSession session){
        List<Roles> rolesList = rolesService.findAllRoles();
        Results results = new Results(Code.success,"查询所有角色成功",rolesList,"查询所有的角色信息");
        return JSON.toJSONString(results);
    }

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByIdRoles",method = RequestMethod.POST)
    public String addRoles(Roles roles, HttpSession session){
        List<Roles> rolesList = rolesService.findAllRoles();
        Results results = new Results(Code.success,"查询所有角色成功",rolesList,"查询所有的角色信息");
        return JSON.toJSONString(results);
    }


    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByIdRoles",method = RequestMethod.POST)
    public String updateRoles(Roles roles, HttpSession session){
        List<Roles> rolesList = rolesService.findAllRoles();
        Results results = new Results(Code.success,"查询所有角色成功",rolesList,"查询所有的角色信息");
        return JSON.toJSONString(results);
    }

    @ResponseBody
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/findByIdRoles",method = RequestMethod.POST)
    public String deleteRoles(String id,HttpSession session){
        List<Roles> rolesList = rolesService.findAllRoles();
        Results results = new Results(Code.success,"查询所有角色成功",rolesList,"查询所有的角色信息");
        return JSON.toJSONString(results);
    }
}
