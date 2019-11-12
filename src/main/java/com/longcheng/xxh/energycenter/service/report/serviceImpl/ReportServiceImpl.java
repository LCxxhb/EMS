package com.longcheng.xxh.energycenter.service.report.serviceImpl;

import com.longcheng.xxh.energycenter.dao.report.ReportMapper;
import com.longcheng.xxh.energycenter.entity.report.Report;
import com.longcheng.xxh.energycenter.service.report.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportMapper reportMapper;

    @Override
    public List<Report> findByTag(String tagType) {
        return reportMapper.findByTag(tagType);
    }

    @Override
    public List<Report> findByAreaname(String areaname) {
        return reportMapper.findByAreaname(areaname);
    }

    @Override
    public List<Report> findByBranchfactory(String branchfactory) {
        return reportMapper.findByBranchfactory(branchfactory);
    }

    @Override
    public List<Report> findByReadTime(String readTime) {
        return reportMapper.findByReadTime(readTime);
    }
}
