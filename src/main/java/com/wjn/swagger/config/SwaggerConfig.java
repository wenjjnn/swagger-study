package com.wjn.swagger.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
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
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("wjn二号分组");
    }

    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示swagger的环境
        Profiles profiles = Profiles.of("dev");

        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean b = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("wjn一号分组")
                .enable(b) //配置是否启用Swagger，如果是false，在浏览器将无法访问
                .select()
                // RequestHandlerSelectors:配置要扫描接口的方式
                // 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                // RequestHandlerSelectors.any() 扫描全部
                // RequestHandlerSelectors.none() 不扫描
                .apis(RequestHandlerSelectors.basePackage("com.wjn.swagger.controller"))
                // 配置如何通过path过滤,即这里只扫描请求以/wjn开头的接口
                .paths(PathSelectors.ant("/wjn/**"))
                .build();


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
