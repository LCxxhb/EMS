package com.longcheng.xxh.energycenter.service;

import com.longcheng.xxh.energycenter.entity.GasPointcollection;
import com.longcheng.xxh.energycenter.mapper.GasPointcollectionMapper;
import com.longcheng.xxh.energycenter.util.DBUtils;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class GasPointcollectionService {

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
    }

