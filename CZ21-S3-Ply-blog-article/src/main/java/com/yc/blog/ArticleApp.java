package com.yc.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.yc.blog")
@EnableEurekaClient
public class ArticleApp {

	public static void main(String[] args) {
		SpringApplication.run(ArticleApp.class, args);
	}
	
}
