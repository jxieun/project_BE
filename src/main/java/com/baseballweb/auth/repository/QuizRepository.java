package com.baseballweb.auth.repository;

import com.baseballweb.auth.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByType(String type);
}