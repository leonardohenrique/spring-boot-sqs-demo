package com.example.sqsdemo.messaging;

import java.io.IOException;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.sqsdemo.service.ThumbnailerService;
import com.example.sqsdemo.service.dto.ThumbnailRequest;
import com.example.sqsdemo.service.dto.ThumbnailResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ThumbnailReceiver {

	@Autowired
	private ThumbnailerService thumbnailerService;

	@Autowired
	private NotificationSender notificationSender;

	@JmsListener(destination = "thumbnail_requests")
	public void receive(String json) throws JMSException {
		log.info("Request received: {}", json);
		try {
			final ThumbnailRequest request = ThumbnailRequest.fromJSON(json);
			ThumbnailResult result = thumbnailerService.createThumbnail(request);
			notificationSender.send(result);
		} catch (IOException ex) {
			log.error("Encountered error while parsing message.", ex);
			throw new JMSException("Encountered error while parsing message.");
		}
	}

}
