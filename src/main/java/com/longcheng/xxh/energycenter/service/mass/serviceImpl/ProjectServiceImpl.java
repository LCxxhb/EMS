package com.longcheng.xxh.energycenter.service.mass.serviceImpl;

import com.alibaba.druid.util.StringUtils;
import com.longcheng.xxh.energycenter.dao.mass.ProjectMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.entity.mass.Project;
import com.longcheng.xxh.energycenter.entity.mass.ProjectExample;
import com.longcheng.xxh.energycenter.service.mass.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public Results insert(Project project) {
        String apiDesc = "添加质量属性接口";
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        project.setCreateDate(dateFormat.format(date));
        if (StringUtils.isEmpty(project.getProjectName())) {
            return new Results(Code.param, "质量名不能为空", "", apiDesc);
        } else {
            try {
                if(projectMapper.insertSelective(project) > 0){
                    return new Results(Code.success, "添加属性成功", "", apiDesc);
                }else {
                    return new Results(Code.error, "添加属性失败", "", apiDesc);
                }
            } catch (Exception e) {
                return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
            }
        }
    }

    @Override
    public Results delete(String id) {
        String apiDesc = "通过id删除质量属性接口";
        if(StringUtils.isEmpty(id)){
            return new Results(Code.param, "参数id不能为空", "", apiDesc);
        }else {
                ProjectExample example = new ProjectExample();
                example.createCriteria().andIdEqualTo(new BigDecimal(id));
                if(projectMapper.deleteByExample(example) > 0){
                    return new Results(Code.success, "删除属性成功", "", apiDesc);
                }else {
                    return new Results(Code.error, "删除属性失败", "", apiDesc);
                }
            }
    }

    @Override
    public Results update(Project project) {
        String apiDesc = "修改质量介质属性接口";
        try {
            ProjectExample example = new ProjectExample();
            example.createCriteria().andIdEqualTo(project.getId());
            if(projectMapper.updateByExampleSelective(project,example) > 0){
                return new Results(Code.success, "修改质量介质属性成功", "", apiDesc);
            }else {
                return new Results(Code.error, "修改质量介质属性失败", "", apiDesc);
            }
        }catch (Exception e) {
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
    public Results findAllProject() {
        String apiDesc = "查所有属性接口";
        try {
            ProjectExample example = new ProjectExample();
            List<Project> projectList = projectMapper.selectByExample(example);
            return new Results(Code.success, "查询所有属性成功", projectList, apiDesc);
        } catch (Exception e) {
            return new Results(Code.trycatch, "捕获到异常" + e.toString(), "", apiDesc);
        }
    }
}
