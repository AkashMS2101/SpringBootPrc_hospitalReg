package com.ty.springboot_hospitalapp.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationDocConfig {
	public Docket getDocket() {
		Contact contact = new Contact("TY", "www.tymc.com", "ty@gmail.com");
		
		@SuppressWarnings("rawtypes")
		List<VendorExtension> list = new ArrayList<VendorExtension>();
		
		ApiInfo apiInfo = new ApiInfo("Hospital_App", "hospital_api v1.0", "version 1.0",
				"www.tymc.com", contact, "asdfgh7hvbn","ty@gmail.com" , list);
		
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.
				basePackage("com.ty.springboot_hospitalapp")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
}
