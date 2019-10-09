package com.longcheng.xxh.energycenter.controller.sys;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.User;
import com.longcheng.xxh.energycenter.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class  UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录校验
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(User user, HttpServletRequest request) {

//        userService.login(user ,request);
        return "用户登录";
    }

    /**
     * [新增]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping("/insert")
    public String insert(User user) {
        return JSON.toJSONString(userService.insert(user));
    }

    /**
     * [新增]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping("/findAll")
    public String findAll() {
        return JSON.toJSONString(userService.findAll());
    }

    /**
     * [刪除]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping("/delete")
    public String delete(int id) {
        return JSON.toJSONString(userService.delete(id));
    }

    /**
     * [更新]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping("/update")
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
    @PostMapping("/findbyId")
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
    @PostMapping("/pageList")
    public Results pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                            @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return userService.pageList(offset, pagesize);

    }

}
