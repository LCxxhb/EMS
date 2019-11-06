package com.longcheng.xxh.energycenter.service.mass.serviceImpl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.longcheng.xxh.energycenter.dao.mass.MediaDataMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.*;
import com.longcheng.xxh.energycenter.service.mass.MediaDataService;
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
public class MediaDataServiceImpl implements MediaDataService {

    @Resource
    private MediaDataMapper mediaDataMapper;


    @Override
    public Results insert(MediaData mediaData) {
        String apiDesc = "添加介质化验数据接口";
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        mediaData.setCreateDate(dateFormat.format(date));
        if (mediaData.getMid() == null) {
            return new Results(Code.param, "介质id不能为空", "", apiDesc);
        } else if(StringUtils.isEmpty(mediaData.getProjectName())) {
            return new Results(Code.param, "属性名不能为空", "", apiDesc);
        }else if(StringUtils.isEmpty(mediaData.getMediaData()) || mediaData.getMediaData().equals("null")) {
            return new Results(Code.param, "化验数据不能为空", "", apiDesc);
        }else if(StringUtils.isEmpty(mediaData.getPatchName())) {
            return new Results(Code.param, "化验点不能为空", "", apiDesc);
        }else {
            try {
                if(mediaDataMapper.insertSelective(mediaData) > 0){
                    return new Results(Code.success, "添加介质化验数据成功", "", apiDesc);
                }else {
                    return new Results(Code.error, "添加介质化验数据失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results insertAll(JSONObject obj) {

        return null;
    }


    @Override
    public Results delete(String id) {
        return null;
    }

    @Override
    public Results update(MediaData mediaData) {
        return null;
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
    public Results findAllMediaData() {
        return null;
    }

    @Override
    public Results findByMidOrPidMediaData(int mid, int pid) {
        String apiDesc = "通过介质id查数据接口";
        try {
            List<MediaData> mediaDataList =  mediaDataMapper.findByMidOrPidMediaData(new BigDecimal(mid),new BigDecimal(pid));
            return new Results(Code.success, "查询所有单位成功", mediaDataList, apiDesc);
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }

    }
}