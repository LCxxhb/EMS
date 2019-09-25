package com.longcheng.xxh.energycenter;

<<<<<<< HEAD
import org.mybatis.spring.annotation.MapperScan;
=======
import com.longcheng.xxh.energycenter.excel.excelToOracle;
import jxl.read.biff.BiffException;
>>>>>>> 558f2e7617156d9bfbff44ba2b0911cbd842c86f
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;

@SpringBootApplication

@MapperScan("com.longcheng.xxh.energycenter.dao")
public class EnergycenterApplication extends SpringBootServletInitializer {

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

<<<<<<< HEAD
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EnergycenterApplication.class);
    }
=======
>>>>>>> 558f2e7617156d9bfbff44ba2b0911cbd842c86f

}
