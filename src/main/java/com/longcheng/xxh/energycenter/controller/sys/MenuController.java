package com.longcheng.xxh.energycenter.controller.sys;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.sys.Menu;
import com.longcheng.xxh.energycenter.service.sys.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * ems_sys_menu
 *
 * @author shadow
 * @date 2019/10/10
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * [新增]
     *
     * @author shadow
     * @date 2019/10/10
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public String insert(Menu menu) {
        return JSON.toJSONString(menuService.insert(menu));
    }

    /**
     * [刪除]
     *
     * @author shadow
     * @date 2019/10/10
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/delete")
    public String delete(String id) {
        return JSON.toJSONString(menuService.delete(id));
    }

    /**
     * [更新]
     *
     * @author shadow
     * @date 2019/10/10
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/update")
    public String update(Menu menu) {
        return JSON.toJSONString(menuService.update(menu));
    }

    /**
     * [更新]
     *
     * @author shadow
     * @date 2019/10/10
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/findParentMenu")
    public String update() {
        return JSON.toJSONString(menuService.findParentMenu());
    }

    /**
     * [查詢] 根據pid 查詢子菜单
     *
     * @author shadow
     * @date 2019/10/10
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/load")
    public String load(int pid) {
        return JSON.toJSONString(menuService.load(pid));
    }

    /**
     * [查询菜单列表]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/findAll")
    public String findAll() {
        return JSON.toJSONString(menuService.findAll());
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
        menuService.pageList(offset, pagesize);
        return "";
    }

}
