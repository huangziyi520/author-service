//package com.canteencenter.utils.utils;
//
//import com.google.common.base.Predicates;
//import org.springframework.context.annotation.Bean;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
////@Configuration
////@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket webApiConfig() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("webApi")
//                .apiInfo(webApiInfo())
//                .select()
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))
//                .build();
//    }
//
//    @Bean
//    public ApiInfo webApiInfo() {
////        ApiInfo apiInfo = new ApiInfo();
//        return null;
//    }
//}
