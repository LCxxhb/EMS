package com.longcheng.xxh.energycenter.service.act;

import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.act.Water;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WaterService {
   /* //参数查询
    public List<Enti> find(String param1, String param2);*/

   /* //主键查询
    public Enti findById(int id);*/

    //历史查询所有
    public List<Enti> findAllPoint();

    //分页查询
    public Results pageList(int count, int pagesize);
    //不定参数历史查询
    public List<Enti>  find_id(String sql, String areaname, String factory, String tagtype, String begintime, String endtime,String datatype);
    //实时查询水介质数据
    public List<Enti> findAll();
    //不定参数实时查询
    List<Enti> findparams( String sql, String datatype,String areaname, String factory, String tagtype);
//    //具体水介质类型实时数据查询
//    List<Enti> findallmedium(String tagtype);
//    //具体水介质分厂实时数据查询
//    List<Enti> findallareaname(String areaname);
//    //具体水介质区域实时数据查询
//    List<Enti> findallfactory(String factory);
//    //具体水介质采集点实时数据查询
//    List<Enti> findallpoint(String point);
}
