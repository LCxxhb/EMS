package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.dao.sys.UserMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.User;
import com.longcheng.xxh.energycenter.service.sys.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * user
 *
 * @author shadow
 * @date 2019/09/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public Results login(User user, HttpServletRequest request) {
        //参数校验validte
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return new Results(Code.param, "用户名或密码为空!!", "", "用户登录接口");
        } else {
            //根据登录信息查询用户信息
            //存放session中用户信息
            request.getSession().setAttribute("user", user);
        }
        return null;
    }

    @Override
    public Results insert(User user) {
        String apiDesc = "添加用户接口";
//        int rs = (int) ((Math.random() * 9 + 1) * Math.pow(10, 10 - 1));//生成10位随机数做主键
//        user.setId(rs);
//        logger.info("生成的用户id为{},用户对象信息为{}", rs, JSON.toJSONString(user));
        // valid
        if (StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getUsername())) {
            return new Results(Code.param, "用户名或密码为空", "", apiDesc);
        } else {
            try {
                if (userMapper.insert(user) > 0) {
                    return new Results(Code.success, "添加用户成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "添加用户失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }


    @Override
    public Results delete(int id) {
        String apiDesc = "删除用户接口";
        // valid
        if (StringUtils.isEmpty(String.valueOf(id))) {
            return new Results(Code.param, "用户id为空!!", "", apiDesc);
        } else {
            try {
                if (userMapper.delete(id) > 0) {
                    return new Results(Code.success, "删除用户成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "删除用户失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }


    @Override
    public Results update(User user) {
        String apiDesc = "修改用户接口";
        // valid
        if (StringUtils.isEmpty(String.valueOf(user.getId()))||StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getUsername())) {
            return new Results(Code.param, "用户id或用户名或用户密码为空", "", apiDesc);
        } else {
            try {
                if (userMapper.update(user) > 0) {
                    return new Results(Code.success, "编辑用户成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "编辑用户失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }


    @Override
    public Results load(int id) {
        String apiDesc = "根据id查询用户接口";
        // valid
        if (StringUtils.isEmpty(String.valueOf(id))) {
            return new Results(Code.param, "查询用户id为空!!", "", apiDesc);
        } else {
            try {
                User user = userMapper.load(id);
                if (user != null) {
                    return new Results(Code.success, "查询用户详情成功", user, apiDesc);
                } else {
                    return new Results(Code.error, "查询用户详情失败", user, apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results findAll() {
        String apiDesc = "查询所有用户接口";
//        try {
            List<User> lists = userMapper.findAll();
            if (lists == null || lists.size() == 0) {
                return new Results(Code.error, "查询用户列表失败", lists, apiDesc);
            } else {
                return new Results(Code.success, "查询用户列表成功", lists, apiDesc);
            }
//        } catch (Exception e) {
//            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
//        }
    }


    @Override
    public Results pageList(int offset, int pagesize) {

        List<User> pageList = userMapper.pageList(offset, pagesize);
        int totalCount = userMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return new Results();
    }

}
