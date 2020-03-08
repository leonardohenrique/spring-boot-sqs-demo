package com.example.sqsdemo.service;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sqsdemo.service.component.ThumbnailCreator;
import com.example.sqsdemo.service.dto.ThumbnailRequest;
import com.example.sqsdemo.service.dto.ThumbnailResult;

@Service
public class ThumbnailerService {

	@Autowired
	private ThumbnailCreator thumbnailCreator;

	public ThumbnailResult createThumbnail(ThumbnailRequest request) throws JMSException {
		final String thumbnailUrl = thumbnailCreator.create(request.getImageUrl());
		return new ThumbnailResult(request, thumbnailUrl);
	}

}
