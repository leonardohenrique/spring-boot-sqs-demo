package com.example.sqsdemo.service.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Data
public class ThumbnailRequest {

	private static ObjectMapper objectMapper = new ObjectMapper();

	private String objectId;
	private String imageUrl;

	public static ThumbnailRequest fromJSON(String json) throws JsonMappingException, JsonProcessingException {
		return objectMapper.readValue(json, ThumbnailRequest.class);
	}
}
