package com.linzlb.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.linzlb.interceptor.Linzb_Interceptor;

@Configuration
public class LinzlbWebAppConfigurer extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Linzb_Interceptor()).addPathPatterns("/**"); // 添加拦截器 以及 拦截器规则
        super.addInterceptors(registry);
    }

}
