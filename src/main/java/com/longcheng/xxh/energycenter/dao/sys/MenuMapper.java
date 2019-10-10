package com.longcheng.xxh.energycenter.dao.sys;

import com.longcheng.xxh.energycenter.entity.sys.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * menu
 * @author shadow
 * @date 2019/10/10
 */
@Mapper
@Repository
public interface MenuMapper {

    /**
     * [新增]
     * @author shadow
     * @date 2019/10/10
     **/
    int insert(Menu menu);

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
    int update(Menu menu);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author shadow
     * @date 2019/10/10
     **/
    Menu load(int id);

    /**
     * [查詢] 分頁查詢
     * @author shadow
     * @date 2019/10/10
     **/
    List<Menu> pageList(int offset,int pagesize);

    /**
     * [查詢] 分頁查詢 count
     * @author shadow
     * @date 2019/10/10
     **/
    int pageListCount(int offset,int pagesize);

}
