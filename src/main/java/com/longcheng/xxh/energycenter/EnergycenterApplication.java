package com.longcheng.xxh.energycenter;

import com.longcheng.xxh.energycenter.util.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@SpringBootApplication
public class EnergycenterApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EnergycenterApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EnergycenterApplication.class);
    }

    /**
     * 加盐加密
     * @return
     */
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * jwt
     * @return
     */
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

    /**
     * 防止请求//报错
     * @return
     */
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }

}
