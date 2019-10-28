package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.dao.sys.RolesMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Roles;
import com.longcheng.xxh.energycenter.entity.sys.User;
import com.longcheng.xxh.energycenter.service.sys.RolesService;
import com.longcheng.xxh.energycenter.util.UserRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * roles
 *
 * @author shadow
 * @date 2019/10/10
 */
@Service
public class RolesServiceImpl implements RolesService {

    @Resource
    private RolesMapper rolesMapper;

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    private final static Logger logger = LoggerFactory.getLogger(RolesServiceImpl.class);

    @Override
    public Results insert(Roles roles) {
        String apiDesc = "添加角色接口";
        // valid
        if (StringUtils.isEmpty(roles.getRolename())) {
            return new Results(Code.param, "角色名称不能为空", "", apiDesc);
        } else {
            roles.setLastUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// 设置时间
            User user = (User) session.getAttribute("user");
            User user1 = (User)  request.getSession().getAttribute("user");
//            User user2 = UserRequest.getCurrentUser();
//            logger.info("user信息为{},user1信息为{},user2信息为{}", JSON.toJSONString(user),JSON.toJSONString(user1),JSON.toJSONString(user2));
            roles.setLastUpdateBy("admin");//设置更新人
            logger.info("角色对象信息为{}", JSON.toJSONString(roles));
            try {
                if (rolesMapper.insert(roles) > 0) {
                    return new Results(Code.success, "添加角色成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "添加角色失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }


    @Override
    public Results delete(String id) {
        String apiDesc = "删除角色接口";
        // valid
        if (StringUtils.isEmpty(id)) {
            return new Results(Code.param, "角色id为空!!", "", apiDesc);
        } else {
            try {
                String[] ids = id.split(",");
                int count = 0;
                for (int i = 0; i < ids.length; i++) {
                    rolesMapper.delete(ids[i]);
                    count++;
                }
                logger.info("删除的角色条数为{}条", count);
                if (count > 0) {
                    return new Results(Code.success, "删除角色信息成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "删除角色信息失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }


    @Override
    public Results update(Roles roles) {
        int ret = rolesMapper.update(roles);
        return new Results();
    }

    @Override
    public Results findAll() {
        String apiDesc = "查询所有角色接口";
        try {
            List<Roles> lists = rolesMapper.findAll();
            if (lists == null || lists.size() == 0) {
                return new Results(Code.error, "查询角色列表为空！", lists, apiDesc);
            } else {
                return new Results(Code.success, "查询角色列表成功", lists, apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

    @Override
    public Results setPermission(String id, String permission) {
        String apiDesc = "角色菜单权限设置接口";
        if (StringUtils.isEmpty(id)||StringUtils.isEmpty(permission)) {
            return new Results(Code.param, "角色id为空或权限菜单列表未选择！", "", apiDesc);
        } else {
            try {
                Roles exroles = rolesMapper.load(Integer.parseInt(id));
                //设置权限
                exroles.setPermission(permission);
                if (rolesMapper.update(exroles)>0) {
                    return new Results(Code.success, "权限分配成功！", "", apiDesc);
                } else {
                    return new Results(Code.error, "权限分配失败！", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results findMenuByRoleId(int id) {
        String apiDesc = "根據根據角色id 查詢菜单列表！";
        if (StringUtils.isEmpty(String.valueOf(id))) {
            return new Results(Code.param, "角色id为空！", "", apiDesc);
        } else {
            try {
                List<HashMap<String,Object>> lists=  rolesMapper.findMenuByRoleId(id);

                if (lists == null || lists.size() == 0) {
                    return new Results(Code.error, "根據根據角色id 查詢菜单列表为空！", "", apiDesc);
                } else {
                    return new Results(Code.success, "根據根據角色id 查詢菜单列表成功！", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }


    @Override
    public Results pageList(int offset, int pagesize) {

        List<Roles> pageList = rolesMapper.pageList(offset, pagesize);
        int totalCount = rolesMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return new Results();
    }

}

