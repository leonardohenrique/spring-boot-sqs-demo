package com.example.sqsdemo.service.component;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ThumbnailCreator {

	public String create(String imageUrl) {
		final String thumbnailUrl = new StringBuilder(imageUrl).insert(imageUrl.lastIndexOf('.'), "_thumbnail")
				.toString();

		log.info("Thumbnail created {} for the image {}", thumbnailUrl, imageUrl);

		return thumbnailUrl;
	}

}
