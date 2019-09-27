package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.longcheng.xxh.energycenter.entity.User;
import com.longcheng.xxh.energycenter.mapper.UserMapper;
import com.longcheng.xxh.energycenter.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User Login(User user) {
        return userMapper.Login(user);
    }
}
