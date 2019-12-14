package com.longcheng.xxh.energycenter.dao.plan;

import com.longcheng.xxh.energycenter.entity.plan.Formula;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * plan
 *
 * @author xieqi
 * @date 2019/11/08
 */
@Mapper
@Repository
public interface FormulaMapper {

    /**
     * [新增]
     * @author xieqi
     * @date 2019/11/16
     **/
    int insert(Formula formula);

    /**
     * [刪除]
     * @author xieqi
     * @date 2019/11/16
     **/
    int delete(String id);

    /**
     * [更新]
     * @author xieqi
     * @date 2019/11/16
     **/
    int update(Formula formula);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author xieqi
     * @date 2019/11/16
     **/
    Formula load(int id);

    /**
     * [查詢] 分頁查詢
     * @author xieqi
     * @date 2019/11/16
     **/
    List<Formula> pageList(int offset,int pagesize);

    /**
     * [查詢] 分頁查詢 count
     * @author xieqi
     * @date 2019/11/16
     **/
    int pageListCount(int offset,int pagesize);

    /**
     * [查詢] 查询所有
     * @author xieqi
     * @date 2019/11/16
     **/
    List<Formula> findAll(Formula formula);
}
