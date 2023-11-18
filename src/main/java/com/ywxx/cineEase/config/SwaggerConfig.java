package com.ywxx.cineEase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;


//@Configuration
//@CrossOrigin
//public class SwaggerConfig {
//    @Bean(value = "defaultApi2")
//    public Docket defaultApi2() {
//        Docket docket=new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(new ApiInfoBuilder()
//                        //.title("swagger-bootstrap-ui-demo RESTful APIs")
//                        .description("# swagger-bootstrap-ui-demo RESTful APIs")
//                        .termsOfServiceUrl("http://www.xx.com/")
//                        .contact("tianhuilin45@gmail.com")
//                        .version("1.0")
//                        .build())
//                //分组名称
//                .groupName("ywxx")
//                .select()
//                // here specify the controller scan package path
//                .apis(RequestHandlerSelectors.basePackage("com.ywxx.controller"))
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }
//}