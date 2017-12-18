package com.gr.bk.service;

import org.apache.ibatis.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gr")
//@EnableConfigurationProperties
public class BkServiceApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		LogFactory.useLog4JLogging();
		SpringApplication.run(BkServiceApplication.class, args);
	}
}
