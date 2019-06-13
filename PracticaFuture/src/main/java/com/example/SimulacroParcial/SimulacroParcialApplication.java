package com.example.SimulacroParcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SimulacroParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimulacroParcialApplication.class, args);
	}

}
