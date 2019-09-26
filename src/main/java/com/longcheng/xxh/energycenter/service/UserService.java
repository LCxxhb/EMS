package com.longcheng.xxh.energycenter.service;

import com.longcheng.xxh.energycenter.entity.User;
import com.longcheng.xxh.energycenter.mapper.UserMapper;
import com.longcheng.xxh.energycenter.util.md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param user
     * @return
     */
    public User Login(User user){
        return userMapper.Login(user);
    }
}
