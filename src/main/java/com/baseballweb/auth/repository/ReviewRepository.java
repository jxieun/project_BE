package com.baseballweb.auth.repository;

import com.baseballweb.auth.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 특정 구장에 대한 모든 리뷰를 조회하는 메소드
    List<Review> findByStadiumId(Long stadiumId);
}
