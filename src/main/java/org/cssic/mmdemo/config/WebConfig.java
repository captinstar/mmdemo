package org.cssic.mmdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 修改静态资源映射，添加上下文路径
        registry.addResourceHandler("/mmdemo/static/**", "/static/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("/mmdemo/templates/**", "/templates/**")
                .addResourceLocations("classpath:/templates/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(3600)
                .resourceChain(true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/mmdemo/dashboard/**", "/mmdemo/api/**")
                .excludePathPatterns("/mmdemo/", "/mmdemo/login",
                        "/mmdemo/api/login", "/mmdemo/api/check-auth",
                        "/mmdemo/static/**");
    }
}