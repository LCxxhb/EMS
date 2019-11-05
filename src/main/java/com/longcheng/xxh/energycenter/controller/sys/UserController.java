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
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/login")
    public String login(User user, HttpServletRequest request) {
        return JSON.toJSONString(userService.login(user, request));
    }

    /**
     * 用户退出
     *
     * @return
     */
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/checkOut")
    public String chekout(HttpServletRequest request) {
        return JSON.toJSONString(userService.checkOut(request));
    }


    /**
     * 用户密码修改
     *
     * @return
     */
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/updatePwd")
    public String updatePassword(String id, String oldPwd, String newPwd) {
        return JSON.toJSONString(userService.updatePassword(id, oldPwd, newPwd));
    }

    /**
     * [新增]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/insert")
    public String insert(User user) {
        return JSON.toJSONString(userService.insert(user));
    }

    /**
     * [查询全部用户]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/findAll")
    public String findAll(User user) {
        return JSON.toJSONString(userService.findAll(user));
    }

    /**
     * [刪除]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/delete")
    public String delete(String id) {
        return JSON.toJSONString(userService.delete(id));
    }

    /**
     * [更新]
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/update")
    public String update(User user) {
        return JSON.toJSONString(userService.update(user));
    }

    /**
     * [查詢] 根據主鍵 id 查詢
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/findbyId")
    public String load(int id) {
        return JSON.toJSONString(userService.load(id));

    }

    /**
     * 充值密码
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/resetPassword")
    public String resetPassword(String id) {
        return JSON.toJSONString(userService.resetPassword(id));
    }

    /**
     * [查詢] 分頁查詢
     *
     * @author shadow
     * @date 2019/09/27
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/pageList")
    public Results pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                            @RequestParam(required = false, defaultValue = "10") int pagesize) {
        return userService.pageList(offset, pagesize);

    }

}
