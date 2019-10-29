package com.longcheng.xxh.energycenter.dao.mass;

import com.longcheng.xxh.energycenter.entity.mass.Media;
import com.longcheng.xxh.energycenter.entity.mass.MediaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MediaMapper {
    long countByExample(MediaExample example);

    int deleteByExample(MediaExample example);

    int insert(Media record);

    int insertSelective(Media record);

    List<Media> selectByExample(MediaExample example);

    int updateByExampleSelective(@Param("record") Media record, @Param("example") MediaExample example);

    int updateByExample(@Param("record") Media record, @Param("example") MediaExample example);
}