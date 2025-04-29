package com.baseballweb.auth.controller;

import com.baseballweb.auth.domain.Review;
import com.baseballweb.auth.dto.ReviewDTO;
import com.baseballweb.auth.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 리뷰 작성 API
    @PostMapping("/add/{stadiumId}")
    public ResponseEntity<ReviewDTO> addReview(@PathVariable Long stadiumId, @RequestBody ReviewDTO reviewDTO) {
        Review review = reviewService.addReview(stadiumId, reviewDTO.getRating(), reviewDTO.getContent(), reviewDTO.getImageUrl());

        // Review를 ReviewDTO로 변환하여 반환
        ReviewDTO responseDTO = new ReviewDTO();
        responseDTO.setRating(review.getRating());
        responseDTO.setContent(review.getContent());
        responseDTO.setImageUrl(review.getImageUrl());

        return ResponseEntity.ok(responseDTO);
    }

    // 특정 구장에 대한 모든 리뷰 조회 API
    @GetMapping("/{stadiumId}")
    public ResponseEntity<List<ReviewDTO>> getReviews(@PathVariable Long stadiumId) {
        List<Review> reviews = reviewService.getReviews(stadiumId);

        // Review 객체들을 ReviewDTO로 변환
        List<ReviewDTO> reviewDTOs = reviews.stream()
                .map(review -> {
                    ReviewDTO dto = new ReviewDTO();
                    dto.setRating(review.getRating());
                    dto.setContent(review.getContent());
                    dto.setImageUrl(review.getImageUrl());
                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(reviewDTOs);
    }
}
