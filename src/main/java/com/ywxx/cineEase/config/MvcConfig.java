package com.ywxx.cineEase.config;


import com.ywxx.cineEase.utils.interceptor.LoginInterceptor;
import com.ywxx.cineEase.utils.interceptor.RefreshTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.annotation.Resource;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Resource
    private StringRedisTemplate StringRedisTemplate;
    //1. add login interceptor

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludePatterns = new String[]{
                "/user/code",
                "/user/login",
                "/movie/**",  // permit all access to movie
                "/pay/**",  // permit all access to pay
                "/movie-type/**",  // permit all access to shop type
                "/booking/**",
                "/upload/**",
                // swagger
                "/doc.html",
                "/webjars/**",
                "/swagger-resources",
                "/v2/api-docs"
        };
        // 1. add login interceptor
        registry.addInterceptor(new LoginInterceptor())
                // 3. add exclude path pattern
                .excludePathPatterns(
                        excludePatterns
                ).order(1);
        // 2. add refresh token interceptor
        // intercept all requests(default)
        // order 0, higher priority than login interceptor
        registry.addInterceptor(new RefreshTokenInterceptor(StringRedisTemplate)).order(0);
    }
}
