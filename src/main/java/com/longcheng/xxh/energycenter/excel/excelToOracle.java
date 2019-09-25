package com.longcheng.xxh.energycenter.excel;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.longcheng.xxh.energycenter.util.DBUtils;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * excel数据导入到oracle
 * @author
 *
 */
public class excelToOracle {


    /**
     *
     * @param path
     *            要解析的excel文件路径
     * @param dataTable
     *            要写入到数据库中的表名
     * @throws BiffException
     * @throws IOException
     */
    public void insert(String path,String dataTable) throws BiffException, IOException {

        File file = new File(path);
        // 创建新的Excel 工作簿
        Workbook rwb = null;
        rwb = Workbook.getWorkbook(file);

        // 得到工作簿中的第一个表索引即为excel下的sheet1,sheet2,sheet3...
        Sheet sheet = rwb.getSheets()[0];
        int rsColumns = sheet.getColumns();// 列数
        int rsRows = sheet.getRows();// 行数
        String simNumber = "" ;//每个单元格中的数据

        DBUtils jdbc=new DBUtils();




        for (int i = 0; i < rsRows; i++) {
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String create_date = dateFormat.format(date);

            System.out.println(create_date);
            String column="ID,CREATE_DATE,COLLECTIONPOINT,BRANCHFACTORY,AREANAME,AREAID,CUSTOMPROPERTIES,DESCRIPTION,TAGTYPE,USETYPE,DATATYPE,DRIVENAME,DEVICENAME,DEVICEADDRESS,SCANMECHANISM,SCANCYCLE,SCANOHASE,ADMITCONTROL,ADMITSCAN,USERANGETRANSFORM,PROJECTUNIT,PROJECTZERO,PROJECTFULL,PROJECTSTARTZERO,PROJECTSTARTFULL,ADMITZEROIMPACTION,ZERO,FLOATINGVALUE";
            String sql = "insert into "+dataTable +"("+column+") values(SEQ_EMS_GAS_POINTCOLLECTION.NEXTVAL,'"+create_date+"'," ;//拼接sql
            for (int j = 0; j < rsColumns; j++) {
                Cell cell = sheet.getCell(j, i);
                simNumber = cell.getContents();


                if(j==rsColumns-1){
                    sql += "'"+ simNumber+"'" ;
                }else{
                    sql +="'"+ simNumber+"',";
                }
            }
            sql += " )";
            System.out.println(sql);
            jdbc.executeUpdate(sql);//执行sql*/

        }

        jdbc.closeStmt();
        jdbc.closeConnection();
    }

    private String column_count(Sheet sheet,String simNumber,String str,int rsColumns){
        for (int j = 0; j <rsColumns; j++) {
            Cell cell = sheet.getCell(j, 0);
            simNumber = cell.getContents();
            if(j==rsColumns-1){
                str +=  simNumber  ;
            }else{
                str +=  simNumber+",";
            }

        }
        return str;
    }

}
