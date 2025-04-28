package com.baseballweb.auth.repository;

import com.baseballweb.auth.domain.PlayerQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerQuizRepository extends JpaRepository<PlayerQuiz, Long> {
}