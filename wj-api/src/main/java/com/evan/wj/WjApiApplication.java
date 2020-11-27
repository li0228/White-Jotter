package com.evan.wj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.evan.wj.mapper") @SpringBootApplication public class WjApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WjApiApplication.class, args);
	}

}
