package com.longcheng.xxh.energycenter.controller;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
<<<<<<< HEAD
=======
import com.longcheng.xxh.energycenter.service.sys.UserService;
>>>>>>> 3ae1c993681cac0bfb1c8af90d0b15b53ab0453c
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Results login(User user) {
        Results result = new Results();
        if (user.getUSERNAME() == null || user.getPASSWORD() == null) {
<<<<<<< HEAD
            result.setErrCode("PARAM");
            result.setErrMsg("4");
=======
            result.setErrCode("4");
            result.setErrMsg("参数校验失败");
>>>>>>> 3ae1c993681cac0bfb1c8af90d0b15b53ab0453c
            result.setResult(null);
            result.setApiDesc("登录接口");
        } else {
            if (userService.Login(user) != null) {
<<<<<<< HEAD
                result.setErrCode("SUCCESS");
                result.setErrMsg("1");
                result.setResult(userService.Login(user));
                result.setApiDesc("登录接口");
            } else {
                result.setErrCode("ERROR");
                result.setErrMsg("2");
=======
                result.setErrCode("1");
                result.setErrMsg("成功");
                result.setResult(userService.Login(user));
                result.setApiDesc("登录接口");
            } else {
                result.setErrCode("2");
                result.setErrMsg("失败");
>>>>>>> 3ae1c993681cac0bfb1c8af90d0b15b53ab0453c
                result.setResult(null);
                result.setApiDesc("登录接口");
            }
        }
        return result;
    }
}
