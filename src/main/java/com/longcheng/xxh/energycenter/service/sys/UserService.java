package com.longcheng.xxh.energycenter.service.sys;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.User;

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
public interface UserService {
    /**
     * 登录
     */
    public Results login(User user , HttpServletRequest request);

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
    public Results resetPassword(int id);
    /**
     * 查詢all
     */
    public Results findAll();
    /**
     * 分页查询
     */
    public Results pageList(int offset, int pagesize);

    /**
     * [查詢] 按条件查询
     * @author shadow
     * @date 2019/09/27
     **/
    public Results listLessonSumByCourseIdList(Map<String,String> map);

}
