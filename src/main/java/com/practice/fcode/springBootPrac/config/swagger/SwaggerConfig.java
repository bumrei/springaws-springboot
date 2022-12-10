package com.practice.fcode.springBootPrac.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.practice.fcode"))
				.paths(PathSelectors.ant("/api/**")) // 해당 String 값으로 시작하는 url 들만 Swagger 표시
				// .paths(PathSelectors.any())
				.build()
				.pathMapping("/roh/"); // 모든 url 들 앞에 해당 String 값 넣기.
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Test Project Swagger")
				.description("연습용 프로젝트 Swagger 설정")
				.version("1.0")
				.build();
	}

}
