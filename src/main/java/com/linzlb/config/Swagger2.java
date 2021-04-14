package com.linzlb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * http://localhost:8888/swagger-ui.html
 *
 * 通过@Configuration注解，表明它是一个配置类，
 * @EnableSwagger2开启swagger2。
 * apiINfo()配置一些基本的信息。apis()指定扫描的包会生成文档。
 */
@Configuration
@EnableSwagger2
public class Swagger2 extends WebMvcConfigurationSupport {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.linzlb.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("The Swagger Title～")
                .description("The Swagger Description")
                .termsOfServiceUrl("https://www.fangzhipeng.com/springboot/2017/05/11/sb11-swagger2.html")
                .version("版本号：1.0")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/META-INF/resources/templates/");
        // 解决静态资源无法访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        // 解决swagger无法访问,2.8.0版本可以找到这个地址的～所以改为这个版本，3.0.0没找到
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}