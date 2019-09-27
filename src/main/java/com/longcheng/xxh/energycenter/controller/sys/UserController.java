package com.longcheng.xxh.energycenter.controller.sys;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.User;
import com.longcheng.xxh.energycenter.service.sys.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/User")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Results login(User user) {
        return userService.login(user);
    }

    /**
     * [新增]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @RequestMapping("/insert")
    public Results insert(User user) {
        return userService.insert(user);
    }

    /**
     * [刪除]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @RequestMapping("/delete")
    public Results delete(int id) {
        return userService.delete(id);
    }

    /**
     * [更新]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @RequestMapping("/update")
    public Results update(User user) {
        return userService.update(user);

    }

    /**
     * [查詢] 根據主鍵 id 查詢
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @RequestMapping("/findbyId")
    public Results load(int id) {
        return userService.load(id);

    }

    /**
     * [查詢] 分頁查詢
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @RequestMapping("/pageList")
    public Results pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                            @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return userService.pageList(offset, pagesize);

    }

}
