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
        }else if(StringUtils.isEmpty(mediaData.getMinimum())) {
            return new Results(Code.param, "化验最小值不能为空", "", apiDesc);
        }else if(StringUtils.isEmpty(mediaData.getMaximum())) {
            return new Results(Code.param, "化验最大值不能为空", "", apiDesc);
        }else {
            try {
                Float mediaData1 = Float.parseFloat(mediaData.getMediaData());
                Float minimum = Float.parseFloat(mediaData.getMinimum());
                Float maximum = Float.parseFloat(mediaData.getMaximum());
                if(mediaData1>=minimum&&mediaData1<=maximum){
                    mediaData.setSpare1("1");
                }else if(mediaData1<minimum){
                    mediaData.setSpare1("2");
                }else if(mediaData1 > maximum){
                    mediaData.setSpare1("3");
                }
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
        String apiDesc = "查询所有数据接口";
        try {
            MediaDataExample example = new MediaDataExample();
            List<MediaData> mediaDataList =  mediaDataMapper.selectByExample(example);
            return new Results(Code.success, "查询所有数据成功", mediaDataList, apiDesc);
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

    @Override
    public Results findByMidOrPidMediaData(int mid, int pid) {
        String apiDesc = "通过介质id查数据接口";
        try {
            List<MediaData> mediaDataList =  mediaDataMapper.findByMidOrPidMediaData(new BigDecimal(mid),new BigDecimal(pid));
            return new Results(Code.success, "查询成功", mediaDataList, apiDesc);
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }

    }

    @Override
    public Results findMediaDataList(int mid,String patchName,String startTime,String endTime,String spare1){
        String apiDesc = "通过条件查数据接口";
        try{
            MediaDataExample example = new MediaDataExample();
            example.setOrderByClause("ID desc");
            MediaDataExample.Criteria criteria1 =  example.createCriteria();
            //MediaDataExample.Criteria criteria2 =  example.createCriteria();
            //MediaDataExample.Criteria criteria3 =  example.createCriteria();
            if(mid != 0){
                criteria1.andMidEqualTo(new BigDecimal(mid));
            }
            if(!StringUtils.isEmpty(patchName)){
                criteria1.andPatchNameEqualTo(patchName);
            }
            if(!"0".equals(startTime)&&!"".equals(startTime)&&!StringUtils.isEmpty(startTime)&&!"0".equals(endTime)&&!"".equals(endTime)&&!StringUtils.isEmpty(endTime)){
//                String startTime1=startTime.replace("/", "-");
//                String endTime1=endTime.replace("/", "-");
                criteria1.andCreateDateBetween(startTime,endTime);
            }
            if(!"0".equals(spare1)){
                criteria1.andSpare1EqualTo(spare1);
            }
            List<MediaData> mediaDataList = mediaDataMapper.selectByExample(example);
            return new Results(Code.success, "通过条件查询数据成功", mediaDataList, apiDesc);
        }catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }

    }
}