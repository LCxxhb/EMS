package com.longcheng.xxh.energycenter.service.mass.serviceImpl;

import com.alibaba.druid.util.StringUtils;
import com.longcheng.xxh.energycenter.dao.mass.MediaMapper;
import com.longcheng.xxh.energycenter.dao.mass.MediaOrProjectMapper;
import com.longcheng.xxh.energycenter.dao.mass.ProjectMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.*;
import com.longcheng.xxh.energycenter.service.mass.MediaOrProjectService;
import com.longcheng.xxh.energycenter.service.mass.MediaService;
import com.longcheng.xxh.energycenter.service.mass.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MediaOrProjectServiceImpl implements MediaOrProjectService {

    @Resource
    private MediaOrProjectMapper mediaOrProjectMapper;

    @Resource
    private MediaMapper mediaMapper;
    @Override
    public Results insert(MediaOrProject mediaOrProject) {
        String apiDesc = "添加质量介质和属性关连数据接口";
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        mediaOrProject.setCreateDate(dateFormat.format(date));
        if (mediaOrProject.getMid() == null) {
            return new Results(Code.param, "介质id不能为空", "", apiDesc);

        } else if(StringUtils.isEmpty(mediaOrProject.getProjectName())) {
            return new Results(Code.param, "属性名不能为空", "", apiDesc);
        }else {
            try {
                MediaExample example = new MediaExample();
                example.createCriteria().andIdEqualTo(mediaOrProject.getMid());
                List<Media> mediaList = mediaMapper.selectByExample(example);
                if (mediaList.size() > 0){
                    Media media =  mediaList.get(0);
                    mediaOrProject.setMediaName(media.getMediaName());
                }
                if(mediaOrProjectMapper.insertSelective(mediaOrProject) > 0){
                    return new Results(Code.success, "添加介质和属性关连数据成功", "", apiDesc);
                }else {
                    return new Results(Code.error, "添加介质和属性关连数据失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results delete(String id) {
        String apiDesc = "通过id删除质量介质和属性关连数据接口";
        if(StringUtils.isEmpty(id)){
            return new Results(Code.param, "参数id不能为空", "", apiDesc);
        }else {
                MediaOrProjectExample example = new MediaOrProjectExample();
                example.createCriteria().andIdEqualTo(new BigDecimal(id));
                if(mediaOrProjectMapper.deleteByExample(example) > 0){
                    return new Results(Code.success, "删除质量介质和属性关连数据成功", "", apiDesc);
                }else {
                    return new Results(Code.error, "删除质量介质和属性关连数据失败", "", apiDesc);
                }
            }
    }

    @Override
    public Results update(MediaOrProject mediaOrProject) {
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
    public Results findAllMediaOrProject() {
        String apiDesc = "查所有属性接口";
        try {
            MediaOrProjectExample example = new MediaOrProjectExample();
            List<MediaOrProject> mediaOrProjectList = mediaOrProjectMapper.selectByExample(example);
            return new Results(Code.success, "查询所有属性成功", mediaOrProjectList, apiDesc);
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

    @Override
    public Results findByMidMediaOrProject(String mid) {
        String apiDesc = "通过Mid查询配置接口";
        if(StringUtils.isEmpty(mid)){
            return new Results(Code.success, "介质id不能为空！", "", apiDesc);
        }else {
            try {
                MediaOrProjectExample example = new MediaOrProjectExample();
                example.createCriteria().andMidEqualTo(new BigDecimal(mid));
                List<MediaOrProject> mediaOrProjectList = mediaOrProjectMapper.selectByExample(example);
                return new Results(Code.success, "通过Mid查询配置成功", mediaOrProjectList, apiDesc);
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }

    }
}
