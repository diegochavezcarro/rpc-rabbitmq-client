package com.dchavez.amqp.client;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RpcRabbitmqClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpcRabbitmqClientApplication.class, args);
	}
	@Bean
	public DirectExchange exchange() {
		return new DirectExchange("tut.rpc");
	}
}
