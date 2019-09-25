package com.longcheng.xxh.energycenter.service.sys.serviceImpl;

import com.longcheng.xxh.energycenter.dao.sys.RegionMapper;
import com.longcheng.xxh.energycenter.entity.sys.Region;
import com.longcheng.xxh.energycenter.entity.sys.RegionExample;
import com.longcheng.xxh.energycenter.service.sys.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionMapper regionMapper;
    @Override
    public List<Region> findAllRegion() {
        RegionExample regionExample = new RegionExample();
        regionExample.createCriteria().andSpare1EqualTo("1");
        List<Region> regions =  regionMapper.selectByExample(regionExample);
        return regions;
    }

    @Override
    public List<Region> findByAid(int aid) {
        RegionExample regionExample = new RegionExample();
        regionExample.createCriteria().andAidEqualTo(new BigDecimal(Integer.toString(aid)));
        List<Region> regions =  regionMapper.selectByExample(regionExample);
        return regions;
    }

    @Override
    public List<Region> findByPid(int pid) {
        RegionExample regionExample = new RegionExample();
        regionExample.createCriteria().andPidEqualTo(Integer.toString(pid));
        List<Region> regions =  regionMapper.selectByExample(regionExample);
        return regions;
    }

    @Override
    public boolean addRegion(Region region) {
        int i = 0;
        if(region.getAid()!=null){
            i = regionMapper.insertRegion(region);
        }

        if(i>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean updateRegion(Region region) {
        int i = regionMapper.updateByPrimaryKey(region);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteRegion(int aid) {
        RegionExample regionExample = new RegionExample();
        regionExample.createCriteria().andAidEqualTo(new BigDecimal(Integer.toString(aid)));
        int i = regionMapper.deleteByExample(regionExample);
        if(i>0){
            return true;
        }else {
            return false;
        }
    }
}
