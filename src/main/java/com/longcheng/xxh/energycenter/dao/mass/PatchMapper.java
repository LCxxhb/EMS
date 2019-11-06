package com.longcheng.xxh.energycenter.dao.mass;

import com.longcheng.xxh.energycenter.entity.mass.Patch;
import com.longcheng.xxh.energycenter.entity.mass.PatchExample;
import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PatchMapper {
    long countByExample(PatchExample example);

    int deleteByExample(PatchExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(Patch record);

    int insertSelective(Patch record);

    List<Patch> selectByExample(PatchExample example);

    Patch selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") Patch record, @Param("example") PatchExample example);

    int updateByExample(@Param("record") Patch record, @Param("example") PatchExample example);

    int updateByPrimaryKeySelective(Patch record);

    int updateByPrimaryKey(Patch record);
}