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

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Results login(User user, HttpServletRequest request) {
        String apiDesc = "用户登录校验接口";
        logger.info("用户登录获取到的参数为{}，{}", user.getUsername(), user.getPassword());
        //参数校验validte
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return new Results(Code.param, "用户名或密码为空!!", "", apiDesc);
        } else {
            try {
                //根据登录信息查询用户信息
                User exUser = userMapper.findUserByNameAndPassword(user);
                logger.info("根据用户名密码查询到的用户信息为{}", JSON.toJSONString(exUser));
                if (exUser == null || exUser.getId() == 0) {
                    return new Results(Code.error, "用户登录校验失败，请检查用户名密码是否正确！", "", apiDesc);
                } else {
                    //将登录的用户信息存放session中
                    request.getSession().setAttribute("user", user);
                    return new Results(Code.success, "用户登录校验成功", exUser, apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results insert(User user) {
        String apiDesc = "添加用户接口";
        logger.info("用户对象信息为{}", JSON.toJSONString(user));
        // valid
        if (StringUtils.isEmpty(user.getUsername())) {
            return new Results(Code.param, "用户名不能为空", "", apiDesc);
        } else if (userMapper.findUserByNameAndPassword(user) != null) {
            return new Results(Code.error, "已存在该用户，不能重复添加！", "", apiDesc);
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
    public Results delete(String id) {
        String apiDesc = "删除用户接口";
        // valid
        if (StringUtils.isEmpty(id)) {
            return new Results(Code.param, "用户id为空!!", "", apiDesc);
        } else {
            try {
                String[] ids = id.split(",");
                int count = 0;
                for (int i = 0; i < ids.length; i++) {
                    userMapper.delete(ids[i]);
                    count++;
                }
                logger.info("删除的用户条数为{}条",count);
                if (count > 0) {
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
        if (StringUtils.isEmpty(String.valueOf(user.getId())) || StringUtils.isEmpty(user.getUsername())) {
            return new Results(Code.param, "用户id或用户名为空", "", apiDesc);
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
    public Results resetPassword(String id) {
        String apiDesc = "用户密码重置";
        // valid
        if (StringUtils.isEmpty(id)) {
            return new Results(Code.param, "参数校验失败id为空!!", "", apiDesc);
        } else {
            try {
                User user = userMapper.load(Integer.parseInt(id));//根据id查询用户进行密码重置
                if (user != null) {
                    //密码重置
                    user.setPassword("000000");
                    if (userMapper.update(user) > 0) {
                        return new Results(Code.success, "用户密码重置成功", "", apiDesc);
                    } else {
                        return new Results(Code.error, "用户密码重置失败", "", apiDesc);
                    }

                } else {
                    return new Results(Code.error, "未查到该用户信息", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results findAll(User user) {
        String apiDesc = "查询所有用户接口";
        try {
            List<HashMap<String,Object>> lists = userMapper.findAll(user);
            if (lists == null || lists.size() == 0) {
                return new Results(Code.error, "查询用户列表为空！", lists, apiDesc);
            } else {
                return new Results(Code.success, "查询用户列表成功", lists, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
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
