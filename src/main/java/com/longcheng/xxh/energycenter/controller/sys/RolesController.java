package com.longcheng.xxh.energycenter.controller.sys;

import com.longcheng.xxh.energycenter.entity.sys.Roles;
import com.longcheng.xxh.energycenter.service.sys.RolesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * roles
 * @author shadow
 * @date 2019/10/10
 */
@RestController
@RequestMapping(value = "/Roles")
public class RolesController {

    @Resource
    private RolesService rolesService;

    /**
     * [新增]
     * @author shadow
     * @date 2019/10/10
     **/
    @RequestMapping("/insert")
    public String insert(Roles roles){
         rolesService.insert(roles);
         return "";
    }

    /**
     * [刪除]
     * @author shadow
     * @date 2019/10/10
     **/
    @RequestMapping("/delete")
    public String delete(int id){
         rolesService.delete(id);
        return "";
    }

    /**
     * [更新]
     * @author shadow
     * @date 2019/10/10
     **/
    @RequestMapping("/update")
    public String update(Roles roles){
        rolesService.update(roles);
        return "";
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author shadow
     * @date 2019/10/10
     **/
    @RequestMapping("/load")
    public String load(int id){
        rolesService.load(id);
        return "";
    }

    /**
     * [查詢] 分頁查詢
     * @author shadow
     * @date 2019/10/10
     **/
    @RequestMapping("/pageList")
    public String pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return "";
    }

}
