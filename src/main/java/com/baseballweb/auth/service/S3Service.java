package com.baseballweb.auth.service;

import com.amazonaws.services.s3.AmazonS3;
//import lombok.Value;import io.jsonwebtoken.io.IOException;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class S3Service {

    private final AmazonS3 amazonS3;
    private final String bucketName;

    @Autowired
    public S3Service(AmazonS3 amazonS3, @Value("${aws.s3.bucket.name}") String bucketName) {
        this.amazonS3 = amazonS3;
        this.bucketName = bucketName;
    }

    // 파일 업로드 메서드
    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // MultipartFile의 InputStream을 직접 사용하여 S3에 파일 업로드
        amazonS3.putObject(new PutObjectRequest(bucketName, fileName, file.getInputStream(), null));

        return amazonS3.getUrl(bucketName, fileName).toString();  // 업로드된 파일 URL 반환
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }
        return convertedFile;
    }
}

//    // MultipartFile을 File로 변환하는 메서드
//    private File convertMultiPartToFile(MultipartFile file) throws IOException {
//        File convertedFile = new File(file.getOriginalFilename());
//        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
//            fos.write(file.getBytes());
//        }
//        return convertedFile;
//    }
