package com.longcheng.xxh.energycenter.service.act.serviceImpl;

import com.longcheng.xxh.energycenter.entity.act.Enti;
import com.longcheng.xxh.energycenter.entity.act.GasPointcollection;
import com.longcheng.xxh.energycenter.dao.act.GasPointcollectionMapper;
import com.longcheng.xxh.energycenter.entity.basepo.Code;
import com.longcheng.xxh.energycenter.entity.basepo.Results;
import com.longcheng.xxh.energycenter.service.act.GasPointcollectionService;
import com.longcheng.xxh.energycenter.util.DBUtils;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GasPointcollectionServiceImpl implements GasPointcollectionService {

    @Autowired
    private GasPointcollectionMapper gasPointcollectionMapper;

    public String upload( String path, String dataTable) {
        File file = new File(path);
        Workbook rwb = null;
        try {
            rwb = Workbook.getWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        // 得到工作簿中的第一个表索引即为excel下的sheet1,sheet2,sheet3...
        Sheet sheet = rwb.getSheets()[0];
        int rsColumns = sheet.getColumns();// 列数
        int rsRows = sheet.getRows();// 行数
        String simNumber = "";//每个单元格中的数据

        DBUtils jdbc = new DBUtils();

        for (int i = 0; i < rsRows; i++) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String create_date = dateFormat.format(date);

            System.out.println(create_date);
            GasPointcollection gasPointcollection = new GasPointcollection();
            String column = gasPointcollection.toString();
            /*    String column="ID,CREATE_DATE,COLLECTIONPOINT,BRANCHFACTORY,AREANAME,AREAID,CUSTOMPROPERTIES,DESCRIPTION,TAGTYPE,USETYPE,DATATYPE,DRIVENAME,DEVICENAME,DEVICEADDRESS,SCANMECHANISM,SCANCYCLE,SCANOHASE,ADMITCONTROL,ADMITSCAN,USERANGETRANSFORM,PROJECTUNIT,PROJECTZERO,PROJECTFULL,PROJECTSTARTZERO,PROJECTSTARTFULL,ADMITZEROIMPACTION,ZERO,FLOATINGVALUE";*/
            String sql = "insert into " + dataTable + "(" +"ID,"+"CREATE_DATE,"+ column + ") values(SEQ_EMS_GAS_POINTCOLLECTION.NEXTVAL,'" + create_date + "',";//拼接sql
            for (int j = 0; j < rsColumns; j++) {
                Cell cell = sheet.getCell(j, i);
                simNumber = cell.getContents();
                if (j == rsColumns - 1) {
                    sql += "'" + simNumber + "'";
                } else {
                    sql += "'" + simNumber + "',";
                }
            }
            sql += " )";
                      System.out.println(sql);
            jdbc.executeUpdate(sql);//执行sql
            jdbc.closeStmt();
            jdbc.closeConnection();
        }
        String a = "导入成功";


        return a;
    }

    private String column_count (Sheet sheet, String simNumber, String str,int rsColumns){
            for (int j = 0; j < rsColumns; j++) {
                Cell cell = sheet.getCell(j, 0);
                simNumber = cell.getContents();
                if (j == rsColumns - 1) {
                    str += simNumber;
                } else {
                    str += simNumber + ",";
                }

            }
            return str;
        }

    @Override
    public List<Enti> find_water(String areaname, String factory, String tagtype) {
        List<Enti> list = null;
        if (areaname != null && factory != null && tagtype != null){
             list = gasPointcollectionMapper.find_gas(areaname, factory, tagtype);
        }else if (areaname == null && factory != null && tagtype != null){
             list = gasPointcollectionMapper.find_gas_factory(factory, tagtype);
        }else if (factory == null && areaname != null && tagtype != null){
             list = gasPointcollectionMapper.find_gas_factory(areaname,tagtype);
        }else if (tagtype == null && areaname != null && factory != null ){
             list = gasPointcollectionMapper.findAllAreaname(areaname);
        }else{
             list = null;
            System.out.println("参数异常");
        }
        return list;
    }

    @Override
    public List<Enti> find_gas(String areaname, String factory, String tagtype) {
        List<Enti> list = null;
        if (areaname != null && factory != null && tagtype != null){
            list = gasPointcollectionMapper.find_gas(areaname, factory, tagtype);
        }else if (areaname == null && factory != null && tagtype != null){
            list = gasPointcollectionMapper.find_gas_factory(factory, tagtype);
        }else if (factory == null && areaname != null && tagtype != null){
            list = gasPointcollectionMapper.find_gas_factory(areaname,tagtype);
        }else if (tagtype == null && areaname != null && factory != null ){
            list = gasPointcollectionMapper.findAllAreaname(areaname);
        }else{
            list = null;
            System.out.println("参数异常");
        }
        return list;
    }

    /**
     * 查找所有
     * @return
     */
    @Override
    public List<Enti> findAll() {
        return gasPointcollectionMapper.findAll();
    }

    /**
     * 查找分厂所有数据
     * @param areaname
     * @return
     */
    @Override
    public List<Enti> findAllPoint(String areaname) {
        return gasPointcollectionMapper.findAllAreaname(areaname);
    }


    /* *//**
     * 根据主键查询
     * @param id
     * @return
     *//*
    public GasPointcollection findById(int id) {
        return gasPointcollectionMapper.findById(id);
    }*/


    /**
     * 分页查询
     * @param count
     * @param pagesize
     * @return
     */
    public Results pageList(int count, int pagesize) {
        List<GasPointcollection> pageList = gasPointcollectionMapper.pageList(count, pagesize);
        int totalCount = gasPointcollectionMapper.pageListCount();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);
        System.out.println(count);
        System.out.println(pagesize);
        System.out.println(pageList);
        System.out.println(totalCount);
        return new Results(Code.success, "查询成功！！", result, "分页查询部分采集点信息");
    }
    }

