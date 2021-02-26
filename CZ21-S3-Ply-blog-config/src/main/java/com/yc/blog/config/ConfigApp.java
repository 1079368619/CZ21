package com.yc.blog.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//开启配置中心服务
@EnableConfigServer
@EnableEurekaClient
public class ConfigApp {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApp.class, args);
	}
	
}
