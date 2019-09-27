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
    public String login(User user) {
        userService.login(user);
        return "";
    }

    /**
     * [新增]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @RequestMapping("/insert")
    public String insert(User user) {
        userService.insert(user);
        return "";
    }

    /**
     * [刪除]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @RequestMapping("/delete")
    public String delete(int id) {
        userService.delete(id);
        return "";
    }

    /**
     * [更新]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @RequestMapping("/update")
    public String update(User user) {
        userService.update(user);
        return "";

    }

    /**
     * [查詢] 根據主鍵 id 查詢
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @RequestMapping("/findbyId")
    public String load(int id) {
        userService.load(id);
        return "";

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
