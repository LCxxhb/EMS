package com.longcheng.xxh.energycenter.dao.act;

import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.act.Gas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GasMapper {


    /**
     * 不定参数查询
     * @param sql
     * @return
     */
    @Select("${sql}")
    List<Enti> find_id(@Param("sql") String sql, @Param("param1") String param1, @Param("param2") String param2, @Param("param3")  String param3, @Param("param4") String param4,@Param("param5") String param5,@Param("param6") String param6);



    /**
     * 查询所有数据
     * mj
     *
     * @return
     */
    @Select("select * from (SELECT A .AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A inner JOIN EMS_HIS_DATA_GAS B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT) where rownum <=1000")
    List<Enti> findAllPoint();


    /**
     * 分页查询
     * mj
     *
     * @param count
     * @return
     */
    @Select("SELECT * FROM ( SELECT A.*, ROWNUM r FROM ( SELECT A.AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A inner JOIN EMS_HIS_DATA_GAS B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT ) A WHERE ROWNUM <= #{pagesize} ) B WHERE r > #{count}")
    List<Enti> pageList(@Param("count") int count, @Param("pagesize") int pagesize);

    /**
     * 分页查询
     * mj
     *
     * @return
     */
    @Select("SELECT count(1) FROM (SELECT A.AREANAME,A .BRANCHFACTORY,B.*FROM EMS_GAS_POINTCOLLECTION A LEFT JOIN EMS_HIS_DATA_GAS B ON A .COLLECTIONPOINT = B.COLLECTIONPOINT)")
    int pageListCount();

    /**
     * 气体实时数据查询
     * @return
     */
    @Select("SELECT * FROM EMS_HIS_DATA_GAS A INNER JOIN (SELECT DISTINCT COLLECTIONPOINT,MAX (READTIME) AS NEW_READTIME FROM EMS_HIS_DATA_GAS GROUP BY COLLECTIONPOINT) D ON A .COLLECTIONPOINT = D .COLLECTIONPOINT AND A .READTIME = D .NEW_READTIME INNER JOIN EMS_GAS_POINTCOLLECTION M ON D.COLLECTIONPOINT=M.COLLECTIONPOINT WHERE A.TAGTYPE LIKE '%气'")
    List<Enti> findall();
    /**
     * 不定参数实时查询
     * @param sql
     * @param param1
     * @param param2
     * @param param3
     * @param param4
     * @return
     */
    @Select("${sql}")
    List<Enti> findparams(@Param("sql") String sql, @Param("param1") String param1, @Param("param2") String param2, @Param("param3")  String param3, @Param("param4") String param4);
//    /**
//     * 具体气体介质类型实时数据查询
//     * @return
//     */
//    @Select("SELECT * FROM EMS_HIS_DATA_GAS A INNER JOIN (SELECT DISTINCT COLLECTIONPOINT,MAX (READTIME) AS NEW_READTIME FROM EMS_HIS_DATA_GAS GROUP BY COLLECTIONPOINT) D ON A .COLLECTIONPOINT = D .COLLECTIONPOINT AND A .READTIME = D .NEW_READTIME INNER JOIN EMS_GAS_POINTCOLLECTION M ON D.COLLECTIONPOINT=M.COLLECTIONPOINT WHERE A.TAGTYPE =#{tagtype}")
//    List<Enti> findallmedium(String tagtype);
//    /**
//     * 具体气体介质分厂实时数据查询
//     * @return
//     */
//    @Select("SELECT * FROM EMS_HIS_DATA_GAS A INNER JOIN (SELECT DISTINCT COLLECTIONPOINT,MAX (READTIME) AS NEW_READTIME FROM EMS_HIS_DATA_GAS GROUP BY COLLECTIONPOINT) D ON A .COLLECTIONPOINT = D .COLLECTIONPOINT AND A .READTIME = D .NEW_READTIME INNER JOIN EMS_GAS_POINTCOLLECTION M ON D.COLLECTIONPOINT=M.COLLECTIONPOINT WHERE M.AREANAME =#{areaname}")
//    List<Enti> findallareaname(String areaname);
//    /**
//     * 具体气体介质区域实时数据查询
//     * @return
//     */
//    @Select("SELECT * FROM EMS_HIS_DATA_GAS A INNER JOIN (SELECT DISTINCT COLLECTIONPOINT,MAX (READTIME) AS NEW_READTIME FROM EMS_HIS_DATA_GAS GROUP BY COLLECTIONPOINT) D ON A .COLLECTIONPOINT = D .COLLECTIONPOINT AND A .READTIME = D .NEW_READTIME INNER JOIN EMS_GAS_POINTCOLLECTION M ON D.COLLECTIONPOINT=M.COLLECTIONPOINT WHERE M.BRANCHFACTORY =#{factory}")
//    List<Enti> findallfactory(String factory);
//    /**
//     * 具体水介质采集点实时数据查询
//     * @return
//     */
//    @Select("SELECT * FROM EMS_HIS_DATA_GAS A INNER JOIN (SELECT DISTINCT COLLECTIONPOINT,MAX (READTIME) AS NEW_READTIME FROM EMS_HIS_DATA_GAS GROUP BY COLLECTIONPOINT) D ON A .COLLECTIONPOINT = D .COLLECTIONPOINT AND A .READTIME = D .NEW_READTIME INNER JOIN EMS_GAS_POINTCOLLECTION M ON D.COLLECTIONPOINT=M.COLLECTIONPOINT WHERE A.COLLECTIONPOINT =#{point}")
//    List<Enti> findallcollpoint(String point);
}
