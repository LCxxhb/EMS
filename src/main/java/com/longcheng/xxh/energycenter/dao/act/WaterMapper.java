package com.longcheng.xxh.energycenter.dao.act;

import com.longcheng.xxh.energycenter.entity.act.Water;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface WaterMapper {
    /**
     * 根据参数查询
     *
     * @param param1
     * @param param2 mj
     * @return
     */
    @Select("select * from EMS_HIS_DATA_WATER where COLLECTIONPOINT = #{param1} and TAGTYPE = #{param2}")
    List<Water> find(String param1, String param2);

    /**
     * 根据主键查询
     *
     * @param id mj
     * @return
     */
    @Select("select * from EMS_HIS_DATA_WATER where ID = #{id}")
    Water findById(int id);

    /**
     * 查询所有数据
     * mj
     *
     * @return
     */
    @Select("select * from EMS_HIS_DATA_WATER")
    List<Water> findAllPoint();

    /**
     * 分页查询
     * mj
     *
     * @param count
     * @return
     */
    @Select("SELECT * FROM ( SELECT A .*, ROWNUM r FROM ( SELECT * FROM EMS_HIS_DATA_WATER ) A WHERE ROWNUM <= #{pagesize} ) B WHERE r > #{count}")
    List<Water> pageList(@Param("count") int count, @Param("pagesize") int pagesize);

    /**
     * 分页查询
     * mj
     *
     * @return
     */
    @Select("SELECT count(1) FROM EMS_HIS_DATA_WATER")
    int pageListCount();
}
