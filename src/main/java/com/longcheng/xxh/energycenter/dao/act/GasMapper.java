package com.longcheng.xxh.energycenter.dao.act;

import com.longcheng.xxh.energycenter.entity.act.Gas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GasMapper {
    /**
     * 根据参数查询
     *
     * @param param1
     * @param param2 mj
     * @return
     */
    @Select("select * from EMS_HIS_DATA_GAS where COLLECTIONPOINT = #{param1} and TAGTYPE = #{param2}")
    List<Gas> find(String param1, String param2);

    /**
     * 根据主键查询
     *
     * @param id mj
     * @return
     */
    @Select("select * from EMS_HIS_DATA_GAS where ID = #{id}")
    Gas findById(int id);

    /**
     * 查询所有数据
     * mj
     *
     * @return
     */
    @Select("select * from EMS_HIS_DATA_GAS")
    List<Gas> findAllPoint();


    /**
     * 分页查询
     * mj
     *
     * @param count
     * @return
     */
    @Select("SELECT * FROM ( SELECT A .*, ROWNUM r FROM ( SELECT * FROM EMS_HIS_DATA_GAS ) A WHERE ROWNUM <= #{pagesize} ) B WHERE r > #{count}")
    List<Gas> pageList(@Param("count") int count, @Param("pagesize") int pagesize);

    /**
     * 分页查询
     * mj
     *
     * @return
     */
    @Select("SELECT count(1) FROM EMS_HIS_DATA_GAS")
    int pageListCount();
}
