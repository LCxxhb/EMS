package com.longcheng.xxh.energycenter.dao.sys;

import com.longcheng.xxh.energycenter.entity.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    int insert(@Param("user") User user);

    /**
     * [刪除]
     * @author shadow
     * @date 2019/09/27
     **/
    int delete(@Param("id") int id);

    /**
     * [更新]
     * @author shadow
     * @date 2019/09/27
     **/
    int update(@Param("user") User user);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author shadow
     * @date 2019/09/27
     **/
    User load(@Param("id") int id);

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
