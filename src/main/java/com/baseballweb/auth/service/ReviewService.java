package com.baseballweb.auth.service;

import com.baseballweb.auth.domain.Review;
import com.baseballweb.auth.domain.Stadium;
import com.baseballweb.auth.repository.ReviewRepository;
import com.baseballweb.auth.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private StadiumRepository stadiumRepository;

    // 리뷰 작성
    public Review addReview(Long stadiumId, int rating, String content, String imageUrl) {
        // stadiumId로 구장을 찾음
        Stadium stadium = stadiumRepository.findById(stadiumId)
                .orElseThrow(() -> new RuntimeException("Stadium not found"));

        // Review 객체 생성
        Review review = new Review();
        review.setRating(rating);
        review.setContent(content);
        review.setImageUrl(imageUrl);
        review.setStadium(stadium); // 구장과 연결

        // 리뷰 저장
        return reviewRepository.save(review);
    }

    // 특정 구장에 대한 모든 리뷰 조회
    public List<Review> getReviews(Long stadiumId) {
        return reviewRepository.findByStadiumId(stadiumId);
    }
}
