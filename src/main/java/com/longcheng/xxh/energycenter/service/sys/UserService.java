package com.longcheng.xxh.energycenter.service.sys;

import com.longcheng.xxh.energycenter.entity.User;

public interface UserService {


    /**
     * 登录
     * @param user
     * @return
     */
    public User Login(User user);
}
