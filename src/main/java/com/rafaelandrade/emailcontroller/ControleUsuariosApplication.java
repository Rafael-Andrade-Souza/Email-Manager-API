package com.rafaelandrade.emailcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ControleUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleUsuariosApplication.class, args);
	}

}
