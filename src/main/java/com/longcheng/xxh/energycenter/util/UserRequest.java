package com.longcheng.xxh.energycenter.util;

import com.longcheng.xxh.energycenter.entity.sys.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserRequest {
    public static User getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User)request.getAttribute("user");
        return user;
    }

}

