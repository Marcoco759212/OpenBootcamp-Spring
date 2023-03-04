package com.mahr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springBooksOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API REST BOOKS")
                        .description("trying that swagger ui works")
                        .version("1.0")
                        .license(new License().name("License").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("finally swagger works :D")
                        .url("this url will be available when i finish the course :v"));

    }
}


