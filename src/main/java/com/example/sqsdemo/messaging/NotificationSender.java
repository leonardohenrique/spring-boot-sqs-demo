package com.example.sqsdemo.messaging;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.example.sqsdemo.service.dto.ThumbnailResult;

@Component
public class NotificationSender {

	@Autowired
	protected JmsTemplate jmsTemplate;

	public void send(ThumbnailResult result) throws IOException {
		jmsTemplate.convertAndSend("thumbnail_results", result.toJSON());
	}

}
