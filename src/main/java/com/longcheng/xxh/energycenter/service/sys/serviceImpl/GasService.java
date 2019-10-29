package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Gas;
import java.util.List;

public interface GasService {
    //参数查询
    public List<Gas> find(String param1, String param2);
    //主键查询
    public Gas findById(int id);
    //查询所有
    public List<Gas> findAllPoint();
    //分页查询
    public Results pageList(int count, int pagesize);
}
