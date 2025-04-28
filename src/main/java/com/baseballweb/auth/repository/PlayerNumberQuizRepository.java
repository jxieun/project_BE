package com.baseballweb.auth.repository;

import com.baseballweb.auth.domain.PlayerNumberQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerNumberQuizRepository extends JpaRepository<PlayerNumberQuiz, Long> {
}
