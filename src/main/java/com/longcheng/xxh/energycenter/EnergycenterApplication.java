package com.longcheng.xxh.energycenter;

import com.longcheng.xxh.energycenter.excel.excelToOracle;
import jxl.read.biff.BiffException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class EnergycenterApplication {

    public static void main(String[] args) {
        excelToOracle in = new excelToOracle();
        try {
            in.insert("C:/Users/zml/Desktop/报表项目筛选.xls","EMS_GAS_POINTCOLLECTION");
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SpringApplication.run(EnergycenterApplication.class, args);
    }


}
