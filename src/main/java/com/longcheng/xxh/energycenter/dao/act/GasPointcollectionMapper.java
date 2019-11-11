package com.longcheng.xxh.energycenter.dao.act;

import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.act.GasPointcollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GasPointcollectionMapper {

    /**
     * 导入
     * @return
     */
     String upload() ;

    /**
     * 区域和水介质查询
     * @param areaname
     * @param factory
     * @param tagtype
     * @return
     */
    @Select("SELECT A .AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A inner JOIN EMS_HIS_DATA_WATER B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT and A.AREANAME = #{areaname} and A.BRANCHFACTORY = #{factory} and B.TAGTYPE = #{tagtype}")
    List<Enti> find_water(String areaname, String factory,String tagtype);

    /**
     * 分厂水介质查询
     * @param areaname
     * @param tagtype
     * @return
     */
    @Select("SELECT A .AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A inner JOIN EMS_HIS_DATA_WATER B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT and A.AREANAME = #{areaname} and  B.TAGTYPE = #{tagtype}")
    List<Enti> find_water_areaname(String areaname, String tagtype);
    /**
     * 区域水介质查询
     * @param factory
     * @param tagtype
     * @return
     */
    @Select("SELECT A .AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A inner JOIN EMS_HIS_DATA_WATER B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT and A.BRANCHFACTORY = #{factory} and  B.TAGTYPE = #{tagtype}")
    List<Enti> find_water_factory(String factory, String tagtype);

    /**
     * 区域和气体介质查询
     * @param areaname
     * @param factory
     * @param tagtype
     * @return
     */
    @Select("SELECT A .AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A inner JOIN EMS_HIS_DATA_GAS B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT and A.AREANAME = #{areaname} and A.BRANCHFACTORY = #{factory} and B.TAGTYPE = #{tagtype}")
    List<Enti> find_gas(String areaname, String factory,String tagtype);

    /**
     * 分厂气体介质查询
     * @param areaname
     * @param tagtype
     * @return
     */
    @Select("SELECT A .AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A inner JOIN EMS_HIS_DATA_GAS B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT and A.AREANAME = #{areaname} and  B.TAGTYPE = #{tagtype}")
    List<Enti> find_gas_areaname(String areaname, String tagtype);
    /**
     * 区域气体介质查询
     * @param factory
     * @param tagtype
     * @return
     */
    @Select("SELECT A .AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A inner JOIN EMS_HIS_DATA_GAS B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT and A.BRANCHFACTORY = #{factory} and  B.TAGTYPE = #{tagtype}")
    List<Enti> find_gas_factory(String factory, String tagtype);


  /*  *//**
     * 根据主键查询
     * @param id
     * mj
     * @return
     *//*
    @Select("select * from EMS_GAS_POINTCOLLECTION where id = #{id}")
    GasPointcollection findById( int id);*/

    /**
     * 查询所有数据
     * mj
     * @return
     */
    @Select("SELECT * FROM (SELECT A .AREANAME,A .BRANCHFACTORY,B.* FROM EMS_GAS_POINTCOLLECTION A INNER JOIN EMS_HIS_DATA_WATER B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT UNION SELECT A .AREANAME,A .BRANCHFACTORY,B.* FROM EMS_GAS_POINTCOLLECTION A INNER JOIN EMS_HIS_DATA_GAS B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT) WHERE ROWNUM <= 1000")
    List<Enti> findAll();
    /**
     * 查询分厂数据
     * mj
     * @return
     */
    @Select("SELECT A .AREANAME,A .BRANCHFACTORY,B.* FROM EMS_GAS_POINTCOLLECTION A INNER JOIN EMS_HIS_DATA_WATER B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT where A.AREANAME = #{areaname} UNION SELECT A .AREANAME,A .BRANCHFACTORY,B.* FROM EMS_GAS_POINTCOLLECTION A INNER JOIN EMS_HIS_DATA_GAS B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT where A.AREANAME = #{areaname}")
    List<Enti> findAllAreaname(String areaname);

    /**
     * 分页查询
     * mj
     * @param count
     * @return
     */
    @Select("SELECT * FROM ( SELECT A .*, ROWNUM r FROM ( SELECT * FROM EMS_GAS_POINTCOLLECTION ) A WHERE ROWNUM <= #{pagesize} ) B WHERE r > #{count}")
    List<GasPointcollection> pageList(@Param("count") int count, @Param("pagesize") int pagesize);

    /**
     * 分页查询
     * mj
     * @return
     */
    @Select("SELECT count(1) FROM EMS_GAS_POINTCOLLECTION")
    int pageListCount();
}
