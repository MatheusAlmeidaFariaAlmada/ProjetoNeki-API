package org.neki.backend.projetoNeki.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import java.util.ArrayList;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfiguration extends WebMvcConfigurationSupport{

	@Bean
    public Docket Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.neki.apirest"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());

    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Projeto API REST",
                "Empresa Neki",
                "1.0",
                "Terms of service",
                new Contact ("Matheus Almeida","matheus.almeida.faria.almada@gmail.com", "https://www.neki-it.com.br/" ),
                "Apache License Version 2.0","Https://apache.org/license.html",
                new ArrayList<VendorExtension>()
                );
        return apiInfo;
    }

}
