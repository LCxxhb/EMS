package com.longcheng.xxh.energycenter.service.sys;


import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.sys.Point;

import java.util.List;

public interface PointService {

    /**
     * 根據主鍵 id 查詢
     */
    public Point findById(int id);


    /**
     * 查询所有采集点信息
     */
    public List<Point> findAllPoint();

    /**
     * 分页查询
     * @return
     */
    public Results pageList(int offset, int pagesize);

    /**
     * 根据区域查询采集点
     */
    public List<Point> findByAreaname(String areaname);


    /**
     * 根据分厂查询采集点
     */
    public List<Point> findByBranchfactory(String branchfactory);

}
