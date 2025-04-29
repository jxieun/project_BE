package com.baseballweb.auth.service;

import com.baseballweb.auth.domain.Review;
import com.baseballweb.auth.domain.Stadium;
import com.baseballweb.auth.repository.ReviewRepository;
import com.baseballweb.auth.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;
    private StadiumRepository stadiumRepository;
    private final S3Service s3Service;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository,
                         StadiumRepository stadiumRepository,
                         S3Service s3Service) {
        this.reviewRepository = reviewRepository;
        this.stadiumRepository = stadiumRepository;
        this.s3Service = s3Service;
    }

    // 리뷰 작성
    public Review addReview(Long stadiumId, double rating, String content, MultipartFile image) {
        // stadiumId로 구장을 찾음
        Stadium stadium = stadiumRepository.findById(stadiumId)
                .orElseThrow(() -> new RuntimeException("Stadium not found"));

        // 이미지 파일이 존재하면 S3에 업로드
        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            try {
                imageUrl = s3Service.uploadFile(image);  // S3에 이미지 업로드
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("이미지 업로드 실패");
            }
        }

        // Review 객체 생성
        Review review = new Review();
        review.setRating(rating);
        review.setContent(content);
        review.setImageUrl(imageUrl);  // 이미지 URL 설정
        review.setStadium(stadium); // 구장과 연결

        // 리뷰 저장
        return reviewRepository.save(review);
    }

    // 특정 구장에 대한 모든 리뷰 조회
    public List<Review> getReviews(Long stadiumId) {
        return reviewRepository.findByStadiumId(stadiumId);
    }
}
