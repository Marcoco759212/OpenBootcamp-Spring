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
				.info(new Info()
						.title("API REST LAPTOPS")
						.description("Documentación API REST")
						.version("1.0")
						.license(new License()
								.name("License")
								.url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation()
						.description("CRUD API REST"));

	}
}
