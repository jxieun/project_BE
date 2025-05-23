package com.baseballweb.auth.repository.quizRepository;

import com.baseballweb.auth.domain.quizDomain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    // 사용자 ID로 점수 조회
    List<Score> findByUserId(Long userId);

    // 퀴즈 ID로 점수 조회
    List<Score> findByQuizId(Long quizId);

//    // 특정 사용자에 대한 모든 점수 가져오기 (랭킹 등을 위한 기능)
//    List<Score> findTop10ByOrderByScoreDesc();  // 예시: 점수가 높은 상위 10명

    Optional<Score> findByUserIdAndQuizId(Long userId, Long quizId);
    List<Score> findTop10ByOrderByScoreDesc();  // 상위 10명 점수 조회
}