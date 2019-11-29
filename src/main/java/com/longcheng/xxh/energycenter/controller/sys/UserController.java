package com.longcheng.xxh.energycenter.controller.sys;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.User;
import com.longcheng.xxh.energycenter.service.sys.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 用户登录校验
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/login", produces = "text/html;charset=UTF-8")
    public String login(User user, HttpServletRequest request) {
        return JSON.toJSONString(userService.login(user, request));
    }

    /**
     * 用户退出
     *
     * @return
     */
    @PostMapping(value = "/checkOut", produces = "text/html;charset=UTF-8")
    public String chekout(HttpServletRequest request) {
        return JSON.toJSONString(userService.checkOut(request));
    }


    /**
     * 用户密码修改
     *
     * @return
     */
    @PostMapping(value = "/updatePwd", produces = "text/html;charset=UTF-8")
    public String updatePassword(String id, String oldPwd, String newPwd) {
        return JSON.toJSONString(userService.updatePassword(id, oldPwd, newPwd));
    }

    /**
     * 用户状态修改
     *
     * @return
     */
    @PostMapping(value = "/isuse", produces = "text/html;charset=UTF-8")
    public String isuse(String ids, String status) {
        return JSON.toJSONString(userService.isuse(ids, status));
    }

    /**
     * [新增]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping(value = "/insert", produces = "text/html;charset=UTF-8")
    public String insert(User user) {
        return JSON.toJSONString(userService.insert(user));
    }

    /**
     * [查询全部用户]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping(value = "/findAll", produces = "text/html;charset=UTF-8")
    public String findAll(User user) {
        return JSON.toJSONString(userService.findAll(user));
    }

    /**
     * [刪除]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping(value = "/delete", produces = "text/html;charset=UTF-8")
    public String delete(String id) {
        return JSON.toJSONString(userService.delete(id));
    }

    /**
     * [更新]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping(value = "/update", produces = "text/html;charset=UTF-8")
    public String update(User user) {
        return JSON.toJSONString(userService.update(user));
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping(value = "/findbyId", produces = "text/html;charset=UTF-8")
    public String load(int id) {
        return JSON.toJSONString(userService.load(id));

    }

    /**
     * 充值密码
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @PostMapping(value = "/resetPassword", produces = "text/html;charset=UTF-8")
    public String resetPassword(String id) {
        return JSON.toJSONString(userService.resetPassword(id));
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
