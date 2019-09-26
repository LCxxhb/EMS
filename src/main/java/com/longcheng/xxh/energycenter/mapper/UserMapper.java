package com.longcheng.xxh.energycenter.mapper;

import com.longcheng.xxh.energycenter.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    /**
     *
     * @param user
     * @return
     */
    @Select("SELECT * FROM EMS_SYS_USER WHERE USERNAME = #{USERNAME} and PASSWORD = #{PASSWORD}")
    User Login(User user);
}
