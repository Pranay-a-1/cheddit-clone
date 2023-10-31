package com.pranay.cheddit.cheddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ChedditApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChedditApplication.class, args);
	}

}
