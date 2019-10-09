package com.longcheng.xxh.energycenter.service.sys;

import com.longcheng.xxh.energycenter.entity.sys.Region;
import com.longcheng.xxh.energycenter.entity.sys.RegionExtend;

import java.util.List;

public interface RegionService {

    //查询所有的区域
    public List<Region> findAllRegion();

    //通过id查询区域
    public List<Region> findByAid(int aid);

    //通过pid查询区域
    public List<RegionExtend> findByPid(int pid);

    //添加区域
    public boolean addRegion(Region region);

    //修改区域
    public boolean updateRegion(Region region);

    //删除区域
    public boolean deleteRegion(String[] aids);

    public  List<RegionExtend> findAllRegionExtend();

    public List<Region> findByOneTwoRegion() ;

    public List<Region> findByTwoRegion();
}
