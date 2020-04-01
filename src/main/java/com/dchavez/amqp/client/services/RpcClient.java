package com.dchavez.amqp.client.services;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@EnableScheduling
public class RpcClient {
	@Autowired
	private RabbitTemplate template;

	@Autowired
	private DirectExchange exchange;
	
	private static final Logger logger = LoggerFactory.getLogger(RpcClient.class);

	int start = 0;

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send() {
		logger.debug(" [x] Requesting fib(" + start + ")");
		Integer response = (Integer) template.convertSendAndReceive(exchange.getName(), "rpc", start++);
		logger.debug(" [.] Got '" + response + "'");
	}

}
