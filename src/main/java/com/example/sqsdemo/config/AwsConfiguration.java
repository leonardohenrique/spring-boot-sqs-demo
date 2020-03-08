package com.example.sqsdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;

@Configuration
public class AwsConfiguration {

	@Value("${aws.accessKeyId}")
	private String accessKeyId;

	@Value("${aws.secretAccessKey}")
	private String secretAccessKey;

	@Bean
	public AWSCredentials credentials() {
		return new BasicAWSCredentials(accessKeyId, secretAccessKey);
	}

	@Bean
	public SQSConnectionFactory connectionFactory(AWSCredentials credentials) {
		return SQSConnectionFactory.builder().withRegion(Region.getRegion(Regions.US_EAST_1))
				.withAWSCredentialsProvider(new AWSStaticCredentialsProvider(credentials)).build();
	}
}
