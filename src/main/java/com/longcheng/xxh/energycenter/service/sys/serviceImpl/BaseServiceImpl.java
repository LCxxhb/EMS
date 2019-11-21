package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.longcheng.xxh.energycenter.dao.sys.UserMapper;
import com.longcheng.xxh.energycenter.entity.sys.User;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class BaseServiceImpl {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserMapper UserMapper;

    /**
     * 获取当前登录人姓名
     */
    public String getCurrentUserName() {
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (org.springframework.util.StringUtils.isEmpty(claims)) {
            throw new RuntimeException("权限不足！");
        }
        return claims.getSubject();
    }

    /**
     * 获取当前登录人
     *
     * @return
     */
    public User getCurrentUser() {
        User user = new User();
        user.setUsername(getCurrentUserName());
        return UserMapper.findUserByName(user);
    }
}
