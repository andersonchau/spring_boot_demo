package com.and.demo.webappall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.and.demo.webappall.base.dao")
public class WebappallApplication extends SpringBootServletInitializer {

//	public static void main(String[] args) {
//
//		SpringApplication.run(WebappallApplication.class, args);
//	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebappallApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebappallApplication.class, args);
	}

}
