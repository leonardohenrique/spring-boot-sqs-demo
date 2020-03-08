package com.example.sqsdemo.service.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
public class ThumbnailResult {

	private static ObjectMapper objectMapper = new ObjectMapper();

	private String objectId;
	private String imageUrl;
	private String thumbnailUrl;

	public ThumbnailResult(ThumbnailRequest request, String thumbnailUrl) {
		this.objectId = request.getObjectId();
		this.imageUrl = request.getImageUrl();
		this.thumbnailUrl = thumbnailUrl;
	}

	public String toJSON() throws JsonProcessingException {
		return objectMapper.writeValueAsString(this);
	}

}
