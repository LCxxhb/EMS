package com.longcheng.xxh.energycenter.controller;

import com.longcheng.xxh.energycenter.entity.User;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Results login(User user) {
        Results result = new Results();
        if (user.getUSERNAME() == null || user.getPASSWORD() == null) {
            result.setErrCode("4");
            result.setErrMsg("参数校验失败");
            result.setResult(null);
            result.setApiDesc("登录接口");
        } else {
            if (userService.Login(user) != null) {
                result.setErrCode("1");
                result.setErrMsg("成功");
                result.setResult(userService.Login(user));
                result.setApiDesc("登录接口");
            } else {
                result.setErrCode("2");
                result.setErrMsg("失败");
                result.setResult(null);
                result.setApiDesc("登录接口");
            }
        }
        return result;
    }
}
