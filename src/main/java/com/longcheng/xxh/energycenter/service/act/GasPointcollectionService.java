package com.longcheng.xxh.energycenter.service.act;

import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.act.GasPointcollection;
import com.longcheng.xxh.energycenter.entity.basepo.Results;

import java.util.List;

public interface GasPointcollectionService {
     //导入
    public String upload( String path, String dataTable);
   /* //水介质和区域查询
    public List<Enti> find_water(String areaname, String factory,String tagtype);
    //气体介质和区域
    public List<Enti> find_gas(String areaname, String factory,String tagtype);*/
    //分厂水介质查询
   /* List<Enti> find_water_areaname(String areaname, String tagtype);
    //区域水介质查询
    List<Enti> find_water_factory(String factory, String tagtype);
    //分厂气体介质查询
    List<Enti> find_gas_areaname(String areaname, String tagtype);
    //区域气体介质查询
    List<Enti> find_gas_factory(String factory, String tagtype);*/
    //根据id查询
    /*public GasPointcollection findById(int id);*/
    //查找所有
    public List<Enti> findAll();
    //分页查询
    public Results pageList(int count, int pagesize);
    //查询所有相同数据类型数据
    List<Enti> findAllDatatype(String datatype);
    //查询某区域所有数据
    List<Enti> findAllFactory(String factory,String begintime,String endreadtime);
    //查询某分厂所有数据
    List<Enti> findAllAreaname(String areaname,String begintime,String endreadtime);
}
