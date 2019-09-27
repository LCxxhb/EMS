package com.longcheng.xxh.energycenter.service.sys;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.User;


/**
 * user
 *
 * @author shadow
 * @date 2019/09/27
 */
public interface UserService {
    /**
     * 登录
     */
    public Results login(User user);

    /**
     * 新增
     */
    public Results insert(User user);

    /**
     * 删除
     */
    public Results delete(int id);

    /**
     * 更新
     */
    public Results update(User user);

    /**
     * 根據主鍵 id 查詢
     */
    public Results load(int id);

    /**
     * 分页查询
     */
    public Results pageList(int offset, int pagesize);

}
