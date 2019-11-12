package com.longcheng.xxh.energycenter.dao.report;

import com.longcheng.xxh.energycenter.entity.report.Report;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lixing
 * @annotation 报表查询
 * @date 2019/10/31 10:57
 */
@Mapper
@Repository
public interface ReportMapper {
    /**
     * @param tagType
     * @return com.longcheng.xxh.energycenter.entity.report.GasReport
     * @author lixing
     * @annotation 按介质查询
     * @date 2019/10/31 10:56
     */
    @Select("SELECT b.AREANAME,b.BRANCHFACTORY,A.COLLECTIONPOINT,b.DESCRIPTION,A.TAGTYPE,A.USETYPE,A.TAGVAL,A.readtime FROM(SELECT * FROM EMS.EMS_HIS_DATA_GAS WHERE TAGTYPE =#{tagType}) A LEFT JOIN EMS.EMS_GAS_POINTCOLLECTION B ON A.COllECTIONPOINT = B.COllECTIONPOINT where rownum<=100")
    List<Report> findByTag(String tagType);

    /**
     * @param areaname
     * @return com.longcheng.xxh.energycenter.entity.report.GasReport
     * @author lixing
     * @annotation 按分厂查询
     * @date 2019/10/31 10:56
     */
    @Select("SELECT A.AREANAME,A.BRANCHFACTORY,B .COLLECTIONPOINT,A.DESCRIPTION,B .TAGTYPE,B .USETYPE,B .TAGVAL,B .readtime FROM (SELECT * FROM EMS.EMS_GAS_POINTCOLLECTION WHERE AREANAME =#{areaname}) A LEFT JOIN EMS.EMS_HIS_DATA_GAS B ON A .COllECTIONPOINT = B.COllECTIONPOINT WHERE ROWNUM <= 100")
    List<Report> findByAreaname(String areaname);

    /**
     * @param branchfactory
     * @return com.longcheng.xxh.energycenter.entity.report.GasReport
     * @author lixing
     * @annotation 按区域查询
     * @date 2019/10/31 10:57
     */
    @Select("SELECT A.AREANAME,A.BRANCHFACTORY,B .COLLECTIONPOINT,A.DESCRIPTION,B .TAGTYPE,B .USETYPE,B .TAGVAL,B .readtime FROM (SELECT * FROM EMS.EMS_GAS_POINTCOLLECTION WHERE BRANCHFACTORY =#{branchfactory}) A LEFT JOIN EMS.EMS_HIS_DATA_GAS B ON A .COllECTIONPOINT = B.COllECTIONPOINT WHERE ROWNUM <= 100")
    List<Report> findByBranchfactory(String branchfactory);

    /**
     * @param readTime
     * @return com.longcheng.xxh.energycenter.entity.report.GasReport
     * @author lixing
     * @annotation 按时间查询
     * @date 2019/10/31 10:59
     */
    List<Report> findByReadTime(String readTime);
}
