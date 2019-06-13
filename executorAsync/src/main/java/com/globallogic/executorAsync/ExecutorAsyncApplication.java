package com.globallogic.executorAsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ExecutorAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExecutorAsyncApplication.class, args);
	}

}

