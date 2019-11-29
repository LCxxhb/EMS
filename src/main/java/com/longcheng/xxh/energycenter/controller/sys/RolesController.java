package com.longcheng.xxh.energycenter.controller.sys;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.sys.Roles;
import com.longcheng.xxh.energycenter.service.sys.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * roles
 *
 * @author shadow
 * @date 2019/10/10
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    /**
     * [新增]
     *
     * @author shadow
     * @date 2019/10/10
     **/
    @PostMapping(value = "/insert", produces = "text/html;charset=UTF-8")
    public String insert(Roles roles) {
        return JSON.toJSONString(rolesService.insert(roles));
    }

    /**
     * [刪除]
     *
     * @author shadow
     * @date 2019/10/10
     **/

    @PostMapping(value = "/delete", produces = "text/html;charset=UTF-8")
    public String delete(String id) {
        return JSON.toJSONString(rolesService.delete(id));
    }

    /**
     * [更新]
     *
     * @author shadow
     * @date 2019/10/10
     **/
    @PostMapping(value = "/update", produces = "text/html;charset=UTF-8")
    public String update(Roles roles) {
        return JSON.toJSONString(rolesService.update(roles));
    }

    /**
     * [查询菜单列表]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping(value = "/findAll", produces = "text/html;charset=UTF-8")
    public String findAll() {
        return JSON.toJSONString(rolesService.findAll());
    }


    /**
     * [查询菜单列表]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping(value = "/setPermission", produces = "text/html;charset=UTF-8")
    public String setPermission(Roles roles) {
        return JSON.toJSONString(rolesService.setPermission(String.valueOf(roles.getId()), roles.getPermission()));
    }

    /**
     * [查詢] 根據角色id 查詢菜单列表
     *
     * @author shadow
     * @date 2019/10/10
     **/
    @PostMapping(value = "/findMenuByRoleId", produces = "text/html;charset=UTF-8")
    public String findMenuByRoleId(int id) {
        return JSON.toJSONString(rolesService.findMenuByRoleId(id));
    }

    /**
     * [查詢] 分頁查詢
     *
     * @author shadow
     * @date 2019/10/10
     **/
    @PostMapping("/pageList")
    public String pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                           @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return "";
    }

}
