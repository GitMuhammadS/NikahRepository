package com.shahbaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication
public class SpMvcProj9MiniprojFileUploadAndDownlaodApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpMvcProj9MiniprojFileUploadAndDownlaodApplication.class, args);
	}
	
	@Bean("multipartResolver")
	public MultipartResolver createCMResolver() {
		StandardServletMultipartResolver r=new StandardServletMultipartResolver();
		return r;
	}
}
