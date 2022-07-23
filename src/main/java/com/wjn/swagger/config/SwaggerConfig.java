package com.wjn.swagger.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    //配置swagger信息 = apiInfo
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("wjn", "http://xxx.xxx.com/wjn", "463267161@qq.com");
        return new ApiInfo(
                "温嘉能的swaggerAPI文档",// 标题
                "Api Swagger 文档",// 描述
                "1.0",// 版本
                "https://mp.weixin.qq.com/s/0-c0MAgtyOeKx6qzmdUG0w",// 组织链接
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
