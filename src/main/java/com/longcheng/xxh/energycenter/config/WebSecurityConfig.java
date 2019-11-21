package com.longcheng.xxh.energycenter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequests所有security全注解配置实现的开端，表示开始说明需要的权限
        //需要的权限分两部分，一拦截的路径，二访问该路径需要的权限
        //antMatchers表示拦截什么路径，permitAll任何权限都可以访问
        //anyRequest()任何请求，authenticated认证后可访问
        //.and().csrf().disable()使csrf拦截失效
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
