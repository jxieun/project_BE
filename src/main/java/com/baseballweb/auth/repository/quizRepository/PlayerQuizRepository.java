package com.baseballweb.auth.repository.quizRepository;

import com.baseballweb.auth.domain.quizDomain.PlayerQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerQuizRepository extends JpaRepository<PlayerQuiz, Long> {
}