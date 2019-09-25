package com.longcheng.xxh.energycenter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;

@SpringBootApplication

public class EnergycenterApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
       /* excelToOracle in = new excelToOracle();
        try {
            in.insert("C:/Users/zml/Desktop/报表项目筛选.xls","EMS_GAS_POINTCOLLECTION");
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        SpringApplication.run(EnergycenterApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EnergycenterApplication.class);
    }


}
