package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.github.mjstewart.querystring.dialect.QueryStringDialect;

@SpringBootApplication
public class HotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

	@Bean
	public TimeProvider timeProvider() {
		return new TimeProvider();
	}

	@Bean
	public QueryStringDialect queryStringDialect() {
		return new QueryStringDialect();
	}

}
