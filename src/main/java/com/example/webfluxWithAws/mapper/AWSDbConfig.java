package com.example.webfluxWithAws.mapper;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSDbConfig {

    private static final String PUB_KEY = "input access id";
    private static final String PRI_KEY = "input access key";

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }

    private AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Regions.AP_SOUTH_1)
                .withCredentials(createCredentials())
                .build();
    }

    private AWSStaticCredentialsProvider createCredentials() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(PUB_KEY, PRI_KEY);
        return new AWSStaticCredentialsProvider(basicAWSCredentials);
    }

}
