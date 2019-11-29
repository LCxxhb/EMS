package com.longcheng.xxh.energycenter.interceptor;

import com.longcheng.xxh.energycenter.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtil jwtUtil;
    private final static Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        logger.info("经过了拦截器");
        //设置缓存区编码为UTF-8编码格式
        response.setCharacterEncoding("UTF-8");
        //在响应中主动告诉浏览器使用UTF-8编码格式来接收数据
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        //可以使用封装类简写Content-Type，使用该方法则无需使用setCharacterEncoding
        response.setContentType("text/html;charset=UTF-8");

        //拦截器只是负责把请求头中包含token的令牌进行一个解析验证
        final String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String token = authHeader.substring(7); // The part after "Bearer " 
            //Token解析           
            try {
                Claims claims = jwtUtil.parseJWT(token);
                if (claims != null) {
                    if ("admin".equals(claims.get("roles"))) {//如果是管理员                
                        request.setAttribute("admin_claims", claims);
                    }
                    if ("user".equals(claims.get("roles"))) {//如果是用户                
                        request.setAttribute("user_claims", claims);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException("token令牌不正确！");
            }
        }
        return true;
    }
}
