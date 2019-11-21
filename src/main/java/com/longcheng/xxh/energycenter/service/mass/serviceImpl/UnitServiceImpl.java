package com.longcheng.xxh.energycenter.service.mass.serviceImpl;

import com.alibaba.druid.util.StringUtils;
import com.longcheng.xxh.energycenter.dao.mass.UnitMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.PatchExample;
import com.longcheng.xxh.energycenter.entity.mass.Unit;
import com.longcheng.xxh.energycenter.entity.mass.UnitExample;
import com.longcheng.xxh.energycenter.service.mass.UnitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Resource
    private UnitMapper unitMapper;

    @Override
    public Results insert(Unit unit) {
        String apiDesc = "添加质量单位接口";
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        unit.setCreateDate(dateFormat.format(date));
        if (StringUtils.isEmpty(unit.getUnitName())) {
            return new Results(Code.param, "单位名不能为空", "", apiDesc);
        } else {
            try {
                if(unitMapper.insertSelective(unit) > 0){
                    return new Results(Code.success, "添加单位成功", "", apiDesc);
                }else {
                    return new Results(Code.error, "添加单位失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results delete(String id) {
        String apiDesc = "通过id删除质量单位接口";
        if(StringUtils.isEmpty(id)){
            return new Results(Code.param, "参数id不能为空", "", apiDesc);
        }else {
                UnitExample example = new UnitExample();
                example.createCriteria().andIdEqualTo(new BigDecimal(id));
                if(unitMapper.deleteByExample(example) > 0){
                    return new Results(Code.success, "删除单位成功", "", apiDesc);
                }else {
                    return new Results(Code.error, "删除单位失败", "", apiDesc);
                }
            }
    }

    @Override
    public Results update(Unit unit) {
        String apiDesc = "修改单位接口";
        try {
            UnitExample example = new UnitExample();
            example.createCriteria().andIdEqualTo(unit.getId());
            if(unitMapper.updateByExampleSelective(unit,example) > 0){
                return new Results(Code.success, "修改介质单位成功", "", apiDesc);
            }else {
                return new Results(Code.error, "修改介质单位失败", "", apiDesc);
            }
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }

    }

    @Override
    public Results load(int id) {
        return null;
    }

    @Override
    public Results pageList(int offset, int pagesize) {
        return null;
    }

    @Override
    public Results findAllUnit() {
        String apiDesc = "查所有单位接口";
        try {
            UnitExample example = new UnitExample();
            List<Unit> unitList = unitMapper.selectByExample(example);
            return new Results(Code.success, "查询所有单位成功", unitList, apiDesc);
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }
}
