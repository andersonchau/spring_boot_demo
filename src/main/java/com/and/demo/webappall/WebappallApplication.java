package com.and.demo.webappall;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import javax.persistence.EntityManager;

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

	@Bean
	public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
		return new JPAQueryFactory(entityManager);
	}
}
