package com.longcheng.xxh.energycenter.service.sys;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.User;

import javax.servlet.http.HttpServletRequest;


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
    public Results login(User user, HttpServletRequest request);

    /**
     * 退出
     */
    public Results checkOut(HttpServletRequest request);

    /**
     * 新增
     */
    public Results insert(User user);

    /**
     * 删除
     */
    public Results delete(String id);

    /**
     * 更新
     */
    public Results update(User user);

    /**
     * 根據主鍵 id 查詢
     */
    public Results load(int id);

    /**
     * 重置用户密码
     */
    public Results resetPassword(String id);

    /**
     * 修改用户密码
     */
    public Results updatePassword(String id, String oldPwd, String newPwd);

    /**
     * 修改用户状态
     */
    public Results isuse(String ids, String status);

    /**
     * 查詢all
     */
    public Results findAll(User user);

    /**
     * 分页查询
     */
    public Results pageList(int offset, int pagesize);


}
