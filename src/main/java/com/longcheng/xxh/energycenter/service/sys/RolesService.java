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
     * 根據主鍵 id 查詢
     */
    public Results load(int id);

    /**
     * 分页查询
     */
    public Results pageList(int offset, int pagesize);

}
