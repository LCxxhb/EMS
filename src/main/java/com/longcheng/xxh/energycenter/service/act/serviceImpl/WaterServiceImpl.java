package com.longcheng.xxh.energycenter.service.act.serviceImpl;

import com.longcheng.xxh.energycenter.dao.act.WaterMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.act.Water;
import com.longcheng.xxh.energycenter.service.act.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WaterServiceImpl implements WaterService {
    @Autowired
    private WaterMapper waterMapper;

    @Override
    public List<Water> find(String param1, String param2) {
        List<Water> list = waterMapper.find(param1, param2);
        return list;
    }

    @Override
    public Water findById(int id) {
        return waterMapper.findById(id);
    }

    @Override
    public List<Water> findAllPoint() {
        return waterMapper.findAllPoint();
    }

    @Override
    public Results pageList(int count, int pagesize) {
        List<Water> pageList = waterMapper.pageList(count, pagesize);
        int totalCount = waterMapper.pageListCount();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        System.out.println(count);
        System.out.println(pagesize);
        System.out.println(pageList);
        System.out.println(totalCount);
        return new Results(Code.success, "查询成功！！", result, "分页查询部分气体l信息");
    }
}
