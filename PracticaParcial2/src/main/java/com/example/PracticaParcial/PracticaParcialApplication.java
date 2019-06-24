package com.example.PracticaParcial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class PracticaParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaParcialApplication.class, args);
	}

}
