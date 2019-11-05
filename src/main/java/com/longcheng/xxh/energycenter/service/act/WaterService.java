package com.longcheng.xxh.energycenter.service.act;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.act.Water;

import java.util.List;

public interface WaterService {
    //参数查询
    public List<Water> find(String param1, String param2);

    //主键查询
    public Water findById(int id);

    //查询所有
    public List<Water> findAllPoint();

    //分页查询
    public Results pageList(int count, int pagesize);
}
