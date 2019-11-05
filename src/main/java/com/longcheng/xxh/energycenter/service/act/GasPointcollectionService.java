package com.longcheng.xxh.energycenter.service.act;

import com.longcheng.xxh.energycenter.entity.act.GasPointcollection;
import com.longcheng.xxh.energycenter.entity.basepo.Results;

import java.util.List;

public interface GasPointcollectionService {
     //导入
    public String upload( String path, String dataTable);
    //历史数据查询
    public List<GasPointcollection> find(String param1, String param2);
    //根据id查询
    public GasPointcollection findById(int id);
    //查找所有
    public List<GasPointcollection> findAllPoint();
    //分页查询
    public Results pageList(int count, int pagesize);
}
