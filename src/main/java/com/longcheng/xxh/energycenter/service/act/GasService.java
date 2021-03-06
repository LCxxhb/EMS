package com.longcheng.xxh.energycenter.service.act;

import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.act.Gas;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GasService {
 /*   //参数查询
    public List<Enti> find(String param1, String param2);*/
    //不定参数查询
     List<Enti>  find_id(String sql, String areaname, String factory, String tagtype, String begintime, String endtime,String datatype);
/*    //主键查询
    public Enti findById(int id);*/
    //查询所有
    public List<Enti> findAllPoint();
    //分页查询
    public Results pageList(int count, int pagesize);
    //实时查询气体数据
    public List<Enti> findAll();
    //不定参数实时查询
    List<Enti> findparams( String sql,String datatype,String areaname, String factory, String tagtype);
//    //具体水介质类型实时数据查询
//    List<Enti> findallmedium(String tagtype);
//    //具体水介质分厂实时数据查询
//    List<Enti> findallareaname(String areaname);
//    //具体水介质区域实时数据查询
//    List<Enti> findallfactory(String factory);
//    //具体水介质区域实时数据查询
//    List<Enti> findallpoint(String point);
}
