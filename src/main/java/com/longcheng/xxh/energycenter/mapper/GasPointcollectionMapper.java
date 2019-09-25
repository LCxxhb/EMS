package com.longcheng.xxh.energycenter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GasPointcollectionMapper {

    /**
     * 导入
     * @return
     */
     String upload() ;
}
