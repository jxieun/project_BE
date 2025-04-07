package com.baseballweb.auth.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/images")
public class ImageController {

    // /images/{imageName}으로 요청을 처리하여 이미지를 반환
    @GetMapping("/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
        try {
            // 이미지 경로가 /images/{imageName}으로 들어오면 해당 파일을 찾아 반환
            Resource image = new ClassPathResource("images/" + imageName);

            if (!image.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 이미지 파일을 반환
            return ResponseEntity.ok(image);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
