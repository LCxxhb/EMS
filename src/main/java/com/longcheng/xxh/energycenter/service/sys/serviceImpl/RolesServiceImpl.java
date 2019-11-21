package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.longcheng.xxh.energycenter.dao.sys.MenuMapper;
import com.longcheng.xxh.energycenter.dao.sys.RolesMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Menu;
import com.longcheng.xxh.energycenter.entity.sys.Roles;
import com.longcheng.xxh.energycenter.service.sys.RolesService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * roles
 *
 * @author shadow
 * @date 2019/10/10
 */
@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesMapper rolesMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private BaseServiceImpl baseServiceImpl;

    private final static Logger logger = LoggerFactory.getLogger(RolesServiceImpl.class);

    @Override
    public Results insert(Roles roles) {
        String apiDesc = "添加角色接口";
        // valid
        if (StringUtils.isEmpty(roles.getRolename())) {
            return new Results(Code.param, "角色名称不能为空", "", apiDesc);
        } else {
            roles.setLastUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// 设置时间
            roles.setLastUpdateBy(baseServiceImpl.getCurrentUserName());
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
        roles.setLastUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// 设置时间
        roles.setLastUpdateBy(baseServiceImpl.getCurrentUserName());
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
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(permission)) {
            return new Results(Code.param, "角色id为空或权限菜单列表未选择！", "", apiDesc);
        } else {
            try {
                Roles exroles = rolesMapper.load(Integer.parseInt(id));
                //设置操作人，操作时间，权限菜单
                exroles.setLastUpdateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// 设置时间
                exroles.setLastUpdateBy(baseServiceImpl.getCurrentUserName());
                exroles.setPermission(permission);
                if (rolesMapper.update(exroles) > 0) {
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
        String apiDesc = "根据角色id 查询菜单列表！";
        if (StringUtils.isEmpty(String.valueOf(id))) {
            return new Results(Code.param, "角色id为空！", "", apiDesc);
        } else {
            try {
                List<HashMap<String, Object>> lists = rolesMapper.findPermissionByRoleId(id);
                String permisson = lists.get(0).get("PERMISSION").toString();//查询出权限
                String[] ids = permisson.split(",");//将权限字符串转换为数组
                List<Menu> rootMenu = menuMapper.findMenuByPermission(ids);//根据权限查询菜单列表,原始的数据
                logger.info("查询出来的菜单列表为{}", JSON.toJSONString(rootMenu));
                if (rootMenu.size() == 0 || rootMenu == null) {
                    return new Results(Code.error, "根据角色id 查询菜单列表为空！", rootMenu, apiDesc);
                } else {
                    // 定义返回的结果list
                    List<Menu> menuList = new ArrayList<Menu>();
                    // 先找到所有的一级菜单
                    for (Menu menu : rootMenu) {
                        // 找到一级菜单
                        if (StringUtils.equals("0", menu.getPid().toString())) {
                            menuList.add(menu);
                        }
                    }
                    // 为一级菜单设置子菜单，getChild是递归调用的
                    for (Menu menu : menuList) {
                        menu.setChildMenus(getChild(menu.getId().toString(), rootMenu));
                    }
                    logger.info("最终返回的菜单列表{}", JSON.toJSONString(menuList));
                    return new Results(Code.success, "根据角色id 查询菜单列表成功！", menuList, apiDesc);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }


    /**
     * 递归查找子菜单
     *
     * @param id       当前菜单id
     * @param rootMenu 要查找的列表
     * @return
     */
    private List<Menu> getChild(String id, List<Menu> rootMenu) {
        // 子菜单
        List<Menu> childList = new ArrayList<>();
        for (Menu menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (StringUtils.isNotBlank(menu.getPid().toString())) {
                if (StringUtils.equals(id, menu.getPid().toString())) {
                    childList.add(menu);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (Menu menu : childList) {// 没有url子菜单还有子菜单
            if (StringUtils.isBlank(menu.getMunuurl())) {
                // 递归
                menu.setChildMenus(getChild(menu.getId().toString(), rootMenu));
            }
        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
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

