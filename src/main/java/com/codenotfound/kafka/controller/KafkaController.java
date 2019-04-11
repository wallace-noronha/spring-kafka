package com.codenotfound.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codenotfound.kafka.model.User;
import com.codenotfound.kafka.producer.Sender;

@RestController
@RequestMapping("kafka")
public class KafkaController {

	private final Sender producer;
	
	@Autowired
	public KafkaController(Sender producer) {
		this.producer = producer;
	}
	
	@PostMapping(value = "publish", consumes = {"application/json"})
	public void sendMessageToKafkaTopic(@RequestBody User user) {
		this.producer.send(user);
	}
}