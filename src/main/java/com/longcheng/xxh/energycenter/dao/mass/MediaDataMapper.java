package com.longcheng.xxh.energycenter.dao.mass;

import com.longcheng.xxh.energycenter.entity.mass.MediaData;
import com.longcheng.xxh.energycenter.entity.mass.MediaDataExample;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MediaDataMapper {
    long countByExample(MediaDataExample example);

    int deleteByExample(MediaDataExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(MediaData record);

    int insertSelective(MediaData record);

    List<MediaData> selectByExample(MediaDataExample example);

    MediaData selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") MediaData record, @Param("example") MediaDataExample example);

    int updateByExample(@Param("record") MediaData record, @Param("example") MediaDataExample example);

    int updateByPrimaryKeySelective(MediaData record);

    int updateByPrimaryKey(MediaData record);

    //@Select("SELECT A.MID,A.MEDIA_NAME,A.PROJECT_NAME,B.PATCH_NAME,A.MINIMUM,A.MAXIMUM,A.UNIT_NAME,A.STATE FROM (SELECT MID,MEDIA_NAME,PROJECT_NAME,\"MINIMUM\",MAXIMUM,UNIT_NAME,STATE FROM EMS_MASS_MEDIA_PROJECT WHERE MID = #{mid}) A LEFT JOIN (SELECT PATCH_NAME FROM EMS_MASS_PATCH WHERE ID=#{pid}) B ON 1=1")
    List<MediaData> findByMidOrPidMediaData(BigDecimal mid,BigDecimal pid);
}