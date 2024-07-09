package com.member_level.member_level.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public Info apiInfo() {
        return new Info()
                .title("Member Level Management REST API")
                .description("API Documentation for Member Level Management System")
                .contact(new Contact()
                        .name("Man Sokleaksa")
                        .email("man.sokleaksa@brown.com.kh")
                        .url("http://www.mansokleaksa.com"))
                .version("1.0.0");
    }
}
