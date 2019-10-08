package com.longcheng.xxh.energycenter.dao.sys;


import com.longcheng.xxh.energycenter.entity.sys.Point;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
@Component
public interface PointMapper {

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author xieqi
     * @date 2019/09/28
     **/
    Point findById(@Param("id") int id);


    /**查询所有采集点*/
    List<Point> findAllPoint();

    /**
     * [查詢] 分頁查詢
     * @author xieqi
     * @date 2019/09/28
     **/
    List<Point> pageList(@Param("offset") int offset, @Param("pagesize") int pagesize);

    /**
     * [查詢] 分頁查詢 count
     * @author xieqi
     * @date 2019/09/28
     **/
    int pageListCount(@Param("offset") int offset, @Param("pagesize") int pagesize);


}
