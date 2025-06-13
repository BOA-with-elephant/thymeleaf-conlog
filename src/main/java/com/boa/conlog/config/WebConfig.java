package com.boa.conlog.config;

import com.boa.conlog.interceptor.CategoryListInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    CategoryListInterceptor categoryListInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(categoryListInterceptor)
                .addPathPatterns("/category/**")
                .excludePathPatterns(
                        "/images/**",
                        "/js/**",
                        "/error"
                );
    }
}
