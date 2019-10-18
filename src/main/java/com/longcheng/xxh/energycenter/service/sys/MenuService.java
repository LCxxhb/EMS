package com.longcheng.xxh.energycenter.service.sys;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Menu;

/**
 * MenuService
 *
 * @author shadow
 * @date 2019/10/10
 */
public interface MenuService {

    /**
     * 新增
     */
    public Results insert(Menu menu);

    /**
     * 删除
     */
    public Results delete(String id);

    /**
     * 更新
     */
    public Results update(Menu menu);

    /**
     * 查詢all
     */
    public Results findAll();

    /**
     * 查询所有父级菜单
     */
    public Results findParentMenu();

    /**
     * 根據主鍵 id 查詢
     */
    public Results load(int id);

    /**
     * 分页查询
     */
    public Results pageList(int offset, int pagesize);

}