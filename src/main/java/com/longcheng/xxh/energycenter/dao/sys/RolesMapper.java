package com.longcheng.xxh.energycenter.dao.sys;

import com.longcheng.xxh.energycenter.entity.sys.Menu;
import com.longcheng.xxh.energycenter.entity.sys.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roles
 * @author shadow
 * @date 2019/10/10
 */
@Mapper
@Repository
public interface RolesMapper {

    /**
     * [新增]
     * @author shadow
     * @date 2019/10/10
     **/
    int insert(Roles roles);

    /**
     * [查詢] 查詢所有
     * @author shadow
     * @date 2019/09/27
     **/
    List<Roles> findAll();
    /**
     * [刪除]
     * @author shadow
     * @date 2019/10/10
     **/
    int delete(int id);

    /**
     * [更新]
     * @author shadow
     * @date 2019/10/10
     **/
    int update(Roles roles);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author shadow
     * @date 2019/10/10
     **/
    Roles load(int id);

    /**
     * [查詢] 分頁查詢
     * @author shadow
     * @date 2019/10/10
     **/
    List<Roles> pageList(int offset,int pagesize);

    /**
     * [查詢] 分頁查詢 count
     * @author shadow
     * @date 2019/10/10
     **/
    int pageListCount(int offset,int pagesize);

}
