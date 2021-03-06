package com.gisuni.hellospringbootjpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("spingbootdatajpa 实验")
                .description("restful 风格的网络接口")
                .version("2.0")
                .build();
    }
    @Bean
    public Docket creatRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gisuni.hellospringbootjpa"))
                .paths(PathSelectors.any())
                .build();
    }
}
