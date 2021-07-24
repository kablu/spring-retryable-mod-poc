package com.retrable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class SpringRetryableModPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRetryableModPocApplication.class, args);
	}

}
