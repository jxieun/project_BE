package com.baseballweb.auth.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class S3Config {
//    @Value("${aws.access.key.id}")
//    private String accessKey;
//
//    @Value("${aws.secret.access.key}")
//    private String secretKey;
//
//    @Value("${aws.s3.bucket.name}")
//    private String bucketName;
//
//    @Value("${aws.region}")
//    private String region;

//    @Bean
//    public AmazonS3 amazonS3() {
//        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
//        return AmazonS3Client.builder()
//                .withRegion(Regions.AP_NORTHEAST_2)
//                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
//                .build();
//    }

    @Bean
    public AmazonS3 amazonS3() {
        return AmazonS3Client.builder()
                .withRegion(Regions.AP_NORTHEAST_2)  // 리전 설정
                .build();  // 자격 증명 관련 설정 없이 IAM 역할로 인증
    }
}
