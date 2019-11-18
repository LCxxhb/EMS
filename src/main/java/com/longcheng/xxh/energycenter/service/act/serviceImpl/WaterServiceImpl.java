package com.longcheng.xxh.energycenter.service.act.serviceImpl;

import com.longcheng.xxh.energycenter.dao.act.WaterMapper;
import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.act.Water;
import com.longcheng.xxh.energycenter.service.act.WaterService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

@Service
public class WaterServiceImpl implements WaterService {
    @Autowired
    private WaterMapper waterMapper;

    public List<Enti>  find_id(String sql, String param, String param2, String param3, String param4, String param5){
        double sum = 0;
        double avg ;
        List<Enti> entilist = waterMapper.find_id(sql, param, param2, param3, param4, param5);
        for (int i = 0; i < entilist.size(); i++) {
            sum += Double.parseDouble(entilist.get(i).getTagVal());
        }
        avg = sum/entilist.size();
        entilist.get(0).setSum(sum);
        entilist.get(0).setAve(avg);
        entilist.get(0).setMax(Double.parseDouble((entilist.get(entilist.size()- 1).getTagVal())));
        entilist.get(0).setMin(Double.parseDouble((entilist.get(0).getTagVal())));
        return entilist;
    }

    @Override
    public List<Enti> find(String param1, String param2) {
        List<Enti> list = waterMapper.find(param1, param2);
        return list;
    }

    @Override
    public Enti findById(int id) {
        return waterMapper.findById(id);
    }

    @Override
    public List<Enti> findAllPoint() {
        return waterMapper.findAllPoint();
    }

    @Override
    public Results pageList(int count, int pagesize) {
        List<Enti> pageList = waterMapper.pageList(count, pagesize);
        int totalCount = waterMapper.pageListCount();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return new Results(Code.success, "查询成功！！", result, "分页查询部分水信息");
    }
}