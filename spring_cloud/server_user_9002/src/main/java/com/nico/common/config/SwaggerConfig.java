package com.nico.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * swagger 整合管理API接口
 * 参考<url href="http://www.jianshu.com/p/8033ef83a8ed">http://www.jianshu.com/p/8033ef83a8ed</url>
 * </p>
 * @author xwolf
 * @date 2017-02-26 20:12
 * @since 1.8
 * @version 1.0.0
 */
/*@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xwolf.boot.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("Swagger API 接口文档")
                .contact("程序猿")
                .version("1.0")
                .build();
    }
}*/
