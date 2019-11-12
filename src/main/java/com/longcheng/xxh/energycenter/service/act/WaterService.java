package com.longcheng.xxh.energycenter.service.act;

import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.act.Water;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WaterService {
    //参数查询
    public List<Enti> find(String param1, String param2);

    //主键查询
    public Enti findById(int id);

    //历史查询所有
    public List<Enti> findAllPoint();

    //分页查询
    public Results pageList(int count, int pagesize);
    //不定参数历史查询
    public List<Enti>  find_id(String sql, String param1, String param2, String param3, String param4, String param5);
    //实时查询水数据
    public List<Enti> findAll();
}
