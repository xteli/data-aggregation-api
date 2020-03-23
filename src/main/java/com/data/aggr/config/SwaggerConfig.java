/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.aggr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author chineduojiteli
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
     @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.data.aggr.controller"))
              //  .paths(regex("/product.*"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "NIBSS Data Aggregation API",
                "NIBSS Data Aggregation API for DMBs",
                "1.0",
                "Terms of service",
                new Contact("Enterprise Software Services", "https://nibss-plc.com.ng", "ess@nibss-plc.com.ng"),
               "NIBSS Data Aggregation Service 1.0",
                "https://nibss-plc.com.ng");
        return apiInfo;
    }
}
