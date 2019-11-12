package com.longcheng.xxh.energycenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *跨域问题处理配置类
 * **/
@Configuration
public class CorsConfig {

    /*
     * 跨域属性过滤配置
     * */
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 1允许任何域名使用
        corsConfiguration.addAllowedOrigin("*");
        // 2允许任何头
        corsConfiguration.addAllowedHeader("*");
        // 3.允许ajax异步请求带cookie信息
        corsConfiguration.setAllowCredentials(true);
        // 4允许任何方法（post、get等）
        corsConfiguration.addAllowedMethod("POST");
        return corsConfiguration;
    }

    /*
     * 过滤器实现
     * */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

}