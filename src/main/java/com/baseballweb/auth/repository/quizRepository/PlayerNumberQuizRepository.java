package com.baseballweb.auth.repository.quizRepository;

import com.baseballweb.auth.domain.quizDomain.PlayerNumberQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerNumberQuizRepository extends JpaRepository<PlayerNumberQuiz, Long> {
}
