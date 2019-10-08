package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.longcheng.xxh.energycenter.dao.sys.PointMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Point;
import com.longcheng.xxh.energycenter.service.sys.PointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PointServiceImpl implements PointService {
    @Resource
    private PointMapper pointMapper;


    @Override
    public Point findById(int id) {
        return pointMapper.findById(id);
    }

    @Override
    public List<Point> findAllPoint() { return pointMapper.findAllPoint(); }


    @Override
    public Results pageList(int offset, int pagesize) {

        List<Point> pageList = pointMapper.pageList(offset, pagesize);
        int totalCount = pointMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return new Results();
    }


}
