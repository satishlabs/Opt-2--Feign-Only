package com.booksearchms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookSearchMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookSearchMsApplication.class, args);
	}

}
