package com.longcheng.xxh.energycenter.service.mass.serviceImpl;

import com.alibaba.druid.util.StringUtils;
import com.longcheng.xxh.energycenter.dao.mass.PatchMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.Patch;
import com.longcheng.xxh.energycenter.entity.mass.PatchExample;
import com.longcheng.xxh.energycenter.entity.mass.Unit;
import com.longcheng.xxh.energycenter.entity.mass.UnitExample;
import com.longcheng.xxh.energycenter.service.mass.PatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * patch
 * @author yangbo
 * @date 2019/10/31
 */
@Service
public class PatchServiceImpl implements PatchService {

    @Resource
    private PatchMapper patchMapper;


    @Override
    public Results insert(Patch patch) {
        String apiDesc = "添加采集点介质名称接口";
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        patch.setCreateDate(dateFormat.format(date));
        if (StringUtils.isEmpty(patch.getPatchName())) {
            return new Results(Code.param, "采集点介质名称不能为空", "", apiDesc);
        } else {
            try {
                if(patchMapper.insertSelective(patch) > 0){
                    return new Results(Code.success, "添加采集点介质名称成功", "", apiDesc);
                }else {
                    return new Results(Code.error, "添加采集点介质名称失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results delete(String id) {
        String apiDesc = "删除采集点介质名称接口";
        if (StringUtils.isEmpty(id)) {
            return new Results(Code.param, "参数id不能为空", "", apiDesc);
        } else {
            try {
                if (patchMapper.deleteByPrimaryKey(new BigDecimal(id)) > 0) {
                    return new Results(Code.success, "删除采集点介质名称成功", "", apiDesc);
                } else {
                    return new Results(Code.error, "删除采集点介质名称失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }
    @Override
    public Results update(Patch patch) {
        String apiDesc = "修改采集点介质名称接口";
        try {
            PatchExample example = new PatchExample();
            example.createCriteria().andIdEqualTo(patch.getId());
            if(patchMapper.updateByExampleSelective(patch,example) > 0){
                return new Results(Code.success, "修改采集点介质名称成功", "", apiDesc);
            }else {
                return new Results(Code.error, "修改采集点介质名称失败", "", apiDesc);
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
    public Results findAllPatch() {
        String apiDesc = "查所有采集点介质名称接口";
        try {
            PatchExample example = new PatchExample();
            List<Patch> patchList = patchMapper.selectByExample(example);
            return new Results(Code.success, "查询所有采集点介质名称成功", patchList, apiDesc);
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }
}