package com.longcheng.xxh.energycenter.dao.sys;

import com.longcheng.xxh.energycenter.entity.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * user
 * @author shadow
 * @date 2019/09/27
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * [新增]
     * @author shadow
     * @date 2019/09/27
     **/
    int insert(User user);

    /**
     * [用户登录校验]
     * @author shadow
     * @date 2019/09/27
     **/
    User findUserByNameAndPassword(User user);

    /**
     * [根据用户名称查询用户信息]
     * @author shadow
     * @date 2019/09/27
     **/
    User findUserByName(User user);
    /**
     * [刪除]
     * @author shadow
     * @date 2019/09/27
     **/
    int delete(@Param("id") String id);
    /**
     * [禁用启用]
     * @author shadow
     * @date 2019/09/27
     **/
    int isuse(@Param("id") String id,@Param("status") String status);

    /**
     * [更新]
     * @author shadow
     * @date 2019/09/27
     **/
    int update(User user);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author shadow
     * @date 2019/09/27
     **/
    User load(@Param("id") int id);

    /**
     * [查詢] 查詢所有
     * @author shadow
     * @date 2019/09/27
     **/
    List<HashMap<String,Object>> findAll(User user);

    /**
     * [查詢] 分頁查詢
     * @author shadow
     * @date 2019/09/27
     **/
    List<User> pageList(@Param("offset") int offset,
                        @Param("pagesize") int pagesize);

    /**
     * [查詢] 分頁查詢 count
     * @author shadow
     * @date 2019/09/27
     **/
    int pageListCount(@Param("offset") int offset,
                      @Param("pagesize") int pagesize);

}
