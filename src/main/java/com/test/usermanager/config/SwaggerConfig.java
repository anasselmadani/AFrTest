package com.test.usermanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.test.usermanager"))
                .build()
                .apiInfo(metaInfo());

    }
    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "User Manager APi",
                "Spring Boot application ",
                "1.0",
                "Terms of Service", new Contact("anass", "", "anasselmadani2500@gmail.com"), "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );
        return apiInfo;
    }

}
