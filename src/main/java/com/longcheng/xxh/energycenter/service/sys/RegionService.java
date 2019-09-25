package com.longcheng.xxh.energycenter.service.sys;

import com.longcheng.xxh.energycenter.entity.sys.Region;

import java.util.List;

public interface RegionService {

    //查询所有的区域
    public List<Region> findAllRegion();

    //通过id查询区域
    public List<Region> findByAid(int aid);

    //通过pid查询区域
    public List<Region> findByPid(int pid);

    //添加区域
    public boolean addRegion(Region region);

    //修改区域
    public boolean updateRegion(Region region);

    //删除区域
    public boolean deleteRegion(int aid);

}
