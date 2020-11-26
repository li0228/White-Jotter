package com.evan.wj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) public class WjApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WjApiApplication.class, args);
	}

}
