package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.dao.sys.UserMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.User;
import com.longcheng.xxh.energycenter.service.sys.UserService;
import com.longcheng.xxh.energycenter.util.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired
    private BaseServiceImpl baseServiceImpl;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

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
                User exUser = userMapper.findUserByName(user);
                logger.info("根据用户名查询到的用户信息为{}", JSON.toJSONString(exUser));
                if (null == exUser) {
                    return new Results(Code.error, "没有查询到该用户信息！", "", apiDesc);
                } else if (encoder.matches(user.getPassword(), exUser.getPassword()) && !StringUtils.equals("0", exUser.getStatus())) {
                    //使得前后端可以通话操作，采用JWT和token技术实现
                    //生成令牌
                    String token = jwtUtil.createJWT(exUser.getId().toString(), exUser.getUsername(), "user");
                    Map<String, Object> map = new HashMap<>();
                    map.put("token", token);
                    map.put("user", exUser);
                    return new Results(Code.success, "用户登录成功", map, apiDesc);
                } else if (StringUtils.equals("0", exUser.getStatus()))
                    return new Results(Code.permission, "此用户已被禁用！", "", apiDesc);
                else {
                    return new Results(Code.error, "用户登录失败！", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results findAll(User user) {
        String apiDesc = "查询所有用户接口";
        //获取当前登录人名称
        String userName = baseServiceImpl.getCurrentUserName();
        logger.info("currentUser用户名称为：{}", userName);
        try {
            List<HashMap<String, Object>> lists = userMapper.findAll(user);
            logger.info("查询到的用户列表为：{}", JSON.toJSONString(lists));
            if (CollectionUtils.isEmpty(lists)) {
                return new Results(Code.success, "查询用户列表为空！", lists, apiDesc);
            } else {
                return new Results(Code.success, "查询用户列表成功", lists, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

    @Override
    public Results checkOut(HttpServletRequest request) {
        String apiDesc = "用户退出！";
        try {
            return new Results(Code.success, "用户退出成功", "", apiDesc);
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

    @Override
    public Results insert(User user) {
        String apiDesc = "添加用户接口";
        user.setLastUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//设置操作时间
        user.setLastUpdateBy(baseServiceImpl.getCurrentUserName());//设置操作人
        logger.info("密码加密前用户对象信息为{}", JSON.toJSONString(user));
        //对密码进行加盐加密
        user.setPassword(encoder.encode(user.getPassword()));
        logger.info("密码加密后用户对象信息为{}", JSON.toJSONString(user));
        // valid
        String errMsg = paramsValid(user);
        if (!StringUtils.equals("参数校验通过",errMsg)) {
            return new Results(Code.param, errMsg, "", apiDesc);
        } else if (userMapper.findUserByName(user) != null) {
            logger.info("已存在{}用户", JSON.toJSONString(user.getUsername()));
            return new Results(Code.error, "用户名重复！", "", apiDesc);

        } else {
            try {
                user.setStatus("1");//1启用状态，0禁用状态
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
    public Results isuse(String ids, String status) {
        String apiDesc = "更新用户状态";
        String msgSuccess = "";
        String msgError = "";
        //判断禁用启用
        if (StringUtils.equals("0", status)) {
            msgSuccess = "用户禁用成功!";
            msgError = "用户禁用成功!";
        } else {
            msgSuccess = "用户启用成功!";
            msgError = "用户启用失败!";
        }
        // valid
        if (StringUtils.isEmpty(ids)) {
            return new Results(Code.param, "请选择用户!", "", apiDesc);
        } else {
            try {
                int count = 0;
                String[] idarr = ids.split(",");
                for (int i = 0; i < idarr.length; i++) {
                    userMapper.isuse(idarr[i], status);
                    count++;
                }
                if (count > 0) {
                    logger.info(msgSuccess);
                    return new Results(Code.success, msgSuccess, "", apiDesc);
                } else {
                    return new Results(Code.error, msgError, "", apiDesc);
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
                logger.info("删除的用户条数为{}条", count);
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
            user.setLastUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//设置操作时间
            user.setLastUpdateBy(baseServiceImpl.getCurrentUserName());//设置操作人
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
                    user.setLastUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));//设置操作时间
                    user.setLastUpdateBy(baseServiceImpl.getCurrentUserName());//设置操作人
                    //密码重置(加盐加密)
                    user.setPassword(encoder.encode("000000"));
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
    public Results updatePassword(String id, String oldPwd, String newPwd) {
        String apiDesc = "用户密码修改！";
        // valid
        if (StringUtils.isEmpty(id)) {
            return new Results(Code.param, "参数校验失败id为空!!", "", apiDesc);
        } else {
            try {
                User exuser = userMapper.load(Integer.parseInt(id));//根据id查询用户进行密码修改
                logger.info("当前数据库用户密码为{}，输入的oldPwd密码为{}，newPwd密码为{}", exuser.getPassword(), oldPwd, newPwd);
                if (!encoder.matches(oldPwd, exuser.getPassword())) {
                    return new Results(Code.error, "当前密码错误！请重新输入！", "", apiDesc);
                } else {
                    //密码修改加盐加密
                    exuser.setPassword(encoder.encode(newPwd));
                    if (userMapper.update(exuser) > 0) {
                        return new Results(Code.success, "用户密码修改成功！", exuser, apiDesc);
                    } else {
                        return new Results(Code.error, "用户密码修改失败！", exuser, apiDesc);
                    }
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
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

    /**
     * 添加用户参数校验方法
     *
     * @param user
     * @return
     */
    public String paramsValid(User user) {
        if (StringUtils.isEmpty(user.getUsername())) {
            return "用户名不能为空！";
        } else if (StringUtils.isEmpty(user.getRoleId())) {
            return "用户角色不能为空！";
        } else if (StringUtils.isEmpty(user.getAreaId().toString())) {
            return "用户所在区域不能为空！";
        } else if (StringUtils.isEmpty(user.getPassword())) {
            return "用户密码不能为空！";
        } else {
            return "参数校验通过";
        }
    }
}
