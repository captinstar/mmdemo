package org.cssic.mmdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String[] STATIC_RESOURCE_PATTERNS = {
            "/mmdemo/static/**",
            "/static/**",
            "/mmdemo/templates/**",
            "/templates/**",
            "/*.html"
    };

    private static final String[] PROTECTED_PATHS = {
            "/mmdemo/dashboard/**",
            "/mmdemo/api/**"
    };

    private static final String[] PUBLIC_PATHS = {
            "/mmdemo/",
            "/mmdemo/login",
            "/mmdemo/register",
            "/mmdemo/api/login",
            "/mmdemo/api/register",
            "/mmdemo/api/check-auth",
            "/mmdemo/static/**"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 基础静态资源
        registry.addResourceHandler("/mmdemo/static/**", "/static/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(3600)
                .resourceChain(true);

        // 模板资源
        registry.addResourceHandler("/mmdemo/templates/**", "/templates/**")
                .addResourceLocations("classpath:/templates/");

        // HTML文件
        registry.addResourceHandler("/*.html")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 认证相关页面
        registry.addViewController("/login").setViewName("forward:/login.html");
        registry.addViewController("/register").setViewName("forward:/register.html");

        // 主页重定向
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.addViewController("/mmdemo").setViewName("forward:/index.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(PROTECTED_PATHS)
                .excludePathPatterns(PUBLIC_PATHS);
    }
}