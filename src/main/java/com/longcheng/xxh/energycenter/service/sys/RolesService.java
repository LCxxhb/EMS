package com.longcheng.xxh.energycenter.service.sys;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Roles;

import java.util.Map;

/**
 * roles
 * @author shadow
 * @date 2019/10/10
 */
public interface RolesService {

    /**
     * 新增
     */
    public Results insert(Roles roles);

    /**
     * 删除
     */
    public Results delete(String id);

    /**
     * 更新
     */
    public Results update(Roles roles);

    /**
     * 查詢all
     */
    public Results findAll();

    /**
     * 权限设置
     */
    public Results setPermission(String id,String permission);

    /**
     * 根據根據角色id 查詢菜单列表
     */
    public Results findMenuByRoleId(int id);

    /**
     * 分页查询
     */
    public Results pageList(int offset, int pagesize);

}
