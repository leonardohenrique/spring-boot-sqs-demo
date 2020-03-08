package com.example.sqsdemo.messaging;

import javax.jms.JMSException;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotificationReceiver {

	@JmsListener(destination = "thumbnail_results")
	public void receive(String json) throws JMSException {
		log.info("Result received: {}", json);
	}

}
