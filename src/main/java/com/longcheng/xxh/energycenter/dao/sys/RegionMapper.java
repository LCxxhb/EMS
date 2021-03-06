package com.longcheng.xxh.energycenter.dao.sys;

import com.longcheng.xxh.energycenter.entity.sys.Region;
import com.longcheng.xxh.energycenter.entity.sys.RegionExample;
import java.math.BigDecimal;
import java.util.List;

import com.longcheng.xxh.energycenter.entity.sys.RegionExtend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    @Select("SELECT a.AID,a.ANAME,a.PID,a.CREATEDATE,a.CREATEBY,a.LASTUPDATEBY,a.LASTUPDATEDATE,a.SPARE1,a.SPARE2,b.ANAME PNAME FROM EMS_SYS_REGION a LEFT JOIN EMS_SYS_REGION b ON a.PID = b.AID")
    List<RegionExtend> findAllRegionExtend();

    @Select("SELECT a.AID,a.ANAME,a.PID,a.CREATEDATE,a.CREATEBY,a.LASTUPDATEBY,a.LASTUPDATEDATE,a.SPARE1,a.SPARE2,b.ANAME PNAME FROM (SELECT * FROM EMS_SYS_REGION WHERE PID = #{pid})   a LEFT JOIN EMS_SYS_REGION b ON a.PID = b.AID " )
    List<RegionExtend> findByPidRegionExtend(int pid);
}