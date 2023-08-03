package com.tech.senthil.youtubeclone;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YoutubeCloneApplication {

	@Value("${accessKey}")
	private String accessKey;

	@Value(("${secretKey}"))
	private String secretKey;

	@Bean
	AmazonS3 getAmazonS3()
	{
		AWSCredentials credentials = new BasicAWSCredentials(
				accessKey,
				secretKey
		);
		AmazonS3 s3client = AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_1)
				.build();
		return s3client;
	}

	public static void main(String[] args) {
		SpringApplication.run(YoutubeCloneApplication.class, args);
	}

}
