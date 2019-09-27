package com.longcheng.xxh.energycenter.dao.sys;

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
