package com.longcheng.xxh.energycenter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication

@MapperScan("com.longcheng.xxh.energycenter.dao")
public class EnergycenterApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EnergycenterApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EnergycenterApplication.class);
    }


}
