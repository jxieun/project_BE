package com.baseballweb.auth.repository;

import com.baseballweb.auth.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByType(String type);  // 퀴즈 유형별 조회
    //Optional<Quiz> findById(Long id);    // 퀴즈 ID로 조회
}

