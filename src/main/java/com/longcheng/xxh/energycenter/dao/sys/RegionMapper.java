package com.longcheng.xxh.energycenter.dao.sys;

import com.longcheng.xxh.energycenter.entity.sys.Region;
import com.longcheng.xxh.energycenter.entity.sys.RegionExample;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RegionMapper {
    long countByExample(RegionExample example);

    int deleteByExample(RegionExample example);

    int deleteByPrimaryKey(BigDecimal aid);

    int insert(Region record);

    int insertSelective(Region record);

    List<Region> selectByExample(RegionExample example);

    Region selectByPrimaryKey(BigDecimal aid);

    int updateByExampleSelective(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByExample(@Param("record") Region record, @Param("example") RegionExample example);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);

    @Insert("insert into EMS_SYS_REGION (ANAME, PID, CREATEDATE, \n" +
            "      CREATEBY, LASTUPDATEDATE, LASTUPDATEBY, \n" +
            "      SPARE1, SPARE2)\n" +
            "    values (#{aname,jdbcType=VARCHAR}, #{pid,jdbcType=VARCHAR}, #{createdate,jdbcType=VARCHAR}, \n" +
            "      #{createby,jdbcType=VARCHAR}, #{lastupdatedate,jdbcType=VARCHAR}, #{lastupdateby,jdbcType=VARCHAR}, \n" +
            "      #{spare1,jdbcType=VARCHAR}, #{spare2,jdbcType=VARCHAR})")
    int insertRegion(Region region);
}