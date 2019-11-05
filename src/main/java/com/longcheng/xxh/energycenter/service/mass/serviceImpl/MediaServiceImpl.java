package com.longcheng.xxh.energycenter.service.mass.serviceImpl;

import com.longcheng.xxh.energycenter.dao.mass.MediaMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.Media;
import com.longcheng.xxh.energycenter.entity.mass.MediaExample;
import com.longcheng.xxh.energycenter.service.mass.MediaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * media
 * @author yangbo
 * @date 2019/10/16
 */
@Service
public class MediaServiceImpl implements MediaService {

    @Resource
    private MediaMapper mediaMapper;


    @Override
    public Results insert(Media media) {
        String apiDesc = "添加质量介质接口";
        //logger.info("用户对象信息为{}", JSON.toJSONString(media));
        // valid
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        media.setCreateDate(dateFormat.format(date));
        if (StringUtils.isEmpty(media.getMediaName())) {
            return new Results(Code.param, "介质名不能为空", "", apiDesc);
        } else if (media.getPid()==null) {
            try {
                media.setPid(new BigDecimal(0));
                if(mediaMapper.insertSelective(media) > 0){
                    return new Results(Code.success, "添加一级介质成功", "", apiDesc);
                }else {
                    return new Results(Code.error, "添加一级介质失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        } else {
            try {
                if(mediaMapper.insert(media) > 0){
                    return new Results(Code.success, "添加二级介质成功", "", apiDesc);
                }else {
                    return new Results(Code.error, "添加二级介质失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results delete(String id) {
        String apiDesc = "通过id删除质量介质接口";
        if(StringUtils.isEmpty(id)){
            return new Results(Code.param, "参数id不能为空", "", apiDesc);
        }else {
            List<Media> list = (List<Media>) this.findByPidMedia(id).getResult();
            if(list.size()==0){
                MediaExample example = new MediaExample();
                example.createCriteria().andIdEqualTo(new BigDecimal(id));
                if(mediaMapper.deleteByExample(example) > 0){
                    return new Results(Code.success, "删除介质成功", "", apiDesc);
                }else {
                    return new Results(Code.error, "删除介质失败", "", apiDesc);
                }
            }else {
                return new Results(Code.param, "有子介质不可删除！！", "", apiDesc);
            }
        }
    }

    @Override
    public Results update(Media media) {
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
    public Results findAllMedia() {
        String apiDesc = "查所有介质接口";
        try {
            MediaExample example = new MediaExample();
            List<Media> mediaList = mediaMapper.selectByExample(example);
            return new Results(Code.success, "查询所有介质成功", mediaList, apiDesc);
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

    @Override
    public Results findByPidMedia(String pid) {
        String apiDesc = "通过pid查询介质接口";
        if(StringUtils.isEmpty(pid)){
            return new Results(Code.param, "参数pid不能为空", "", apiDesc);
        }else {
            try {
                MediaExample example = new MediaExample();
                example.createCriteria().andPidEqualTo(new BigDecimal(pid));
                List<Media> mediaList = mediaMapper.selectByExample(example);
                return new Results(Code.success, "通过pid查询介质成功", mediaList, apiDesc);
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }

    }

    @Override
    public Results findByOneMedia() {
        String apiDesc = "查一级介质接口";
        try {
            MediaExample example = new MediaExample();
            example.createCriteria().andPidEqualTo(new BigDecimal(0));
            List<Media> mediaList = mediaMapper.selectByExample(example);
            return new Results(Code.success, "查询一级介质成功", mediaList, apiDesc);
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }

    @Override
    public Results findByTwoMedia() {
        String apiDesc = "查二级介质接口";
        try {
            MediaExample example = new MediaExample();
            example.createCriteria().andPidNotEqualTo(new BigDecimal(0));
            List<Media> mediaList = mediaMapper.selectByExample(example);
            return new Results(Code.success, "查询二级介质成功", mediaList, apiDesc);
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }
}