package com.longcheng.xxh.energycenter.controller.sys;

import com.longcheng.xxh.energycenter.entity.sys.Menu;
import com.longcheng.xxh.energycenter.service.sys.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ems_sys_menu
 * @author shadow
 * @date 2019/10/10
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController{

    @Resource
    private MenuService menuService;

    /**
     * [新增]
     * @author shadow
     * @date 2019/10/10
     **/
    @RequestMapping("/insert")
    public String insert(Menu menu){
        menuService.insert(menu);
        return "";
    }

    /**
     * [刪除]
     * @author shadow
     * @date 2019/10/10
     **/
    @RequestMapping("/delete")
    public String delete(int id){
        menuService.delete(id);
        return "";
    }

    /**
     * [更新]
     * @author shadow
     * @date 2019/10/10
     **/
    @RequestMapping("/update")
    public String update(Menu menu){
         menuService.update(menu);
        return"";
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author shadow
     * @date 2019/10/10
     **/
    @RequestMapping("/load")
    public String load(int id){
         menuService.load(id);
        return"";
    }

    /**
     * [查詢] 分頁查詢
     * @author shadow
     * @date 2019/10/10
     **/
    @RequestMapping("/pageList")
    public String pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
         menuService.pageList(offset, pagesize);
        return"";
    }

}
