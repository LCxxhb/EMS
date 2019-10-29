package com.longcheng.xxh.energycenter.dao.mass;

import com.longcheng.xxh.energycenter.entity.mass.MediaOrProject;
import com.longcheng.xxh.energycenter.entity.mass.MediaOrProjectExample;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MediaOrProjectMapper {
    long countByExample(MediaOrProjectExample example);

    int deleteByExample(MediaOrProjectExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(MediaOrProject record);

    int insertSelective(MediaOrProject record);

    List<MediaOrProject> selectByExample(MediaOrProjectExample example);

    MediaOrProject selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") MediaOrProject record, @Param("example") MediaOrProjectExample example);

    int updateByExample(@Param("record") MediaOrProject record, @Param("example") MediaOrProjectExample example);

    int updateByPrimaryKeySelective(MediaOrProject record);

    int updateByPrimaryKey(MediaOrProject record);
}