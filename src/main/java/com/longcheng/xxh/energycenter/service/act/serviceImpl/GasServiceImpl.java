package com.longcheng.xxh.energycenter.service.act.serviceImpl;

import com.longcheng.xxh.energycenter.dao.act.GasMapper;
import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.act.Gas;
import com.longcheng.xxh.energycenter.service.act.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GasServiceImpl implements GasService {
    @Autowired
    private GasMapper gasMapper;

    @Override
    public List<Enti> find(String param1, String param2) {
        if (param1.isEmpty()){
            /*gasMapper.find()*/
        }
        List<Enti> list = gasMapper.find(param1,param2);
        System.out.println(list);
        return list;
    }

    /*@Override
    public List<Enti> find(String param1, String param2, String param3) {
        List<Enti> list = gasMapper.find(param1,param2,param3);
        System.out.println(list);
        return list;
    }*/

    @Override
    public Gas findById(int id) {
        return gasMapper.findById(id);
    }

    @Override
    public List<Gas> findAllPoint() {
        return gasMapper.findAllPoint();
    }

    @Override
    public Results pageList(int count, int pagesize) {
        List<Gas> pageList = gasMapper.pageList(count, pagesize);
        int totalCount = gasMapper.pageListCount();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        return new Results(Code.success,"查询成功！！",result,"分页查询部分气体信息");
    }
}
