package com.yc.favorite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.yc.favorite.dao")
@EnableTransactionManagement
public class FavoriteApp {

	public static void main(String[] args) {
		SpringApplication.run(FavoriteApp.class, args);
	}

	
}
