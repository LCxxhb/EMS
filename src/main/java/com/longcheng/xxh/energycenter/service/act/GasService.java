package com.longcheng.xxh.energycenter.service.act;

import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.act.Gas;
import java.util.List;

public interface GasService {
    //参数查询
    public List<Enti> find(String param1, String param2);
    //不定参数查询
     List<Enti>  find_id(String sql, String param1, String param2, String param3, String param4, String param5);
    //主键查询
    public Enti findById(int id);
    //查询所有
    public List<Enti> findAllPoint();
    //分页查询
    public Results pageList(int count, int pagesize);
    //实时查询气体数据
    public List<Enti> findAll();
}
