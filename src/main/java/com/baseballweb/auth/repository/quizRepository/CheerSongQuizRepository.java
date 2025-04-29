package com.baseballweb.auth.repository.quizRepository;

import com.baseballweb.auth.domain.quizDomain.CheerSongQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheerSongQuizRepository extends JpaRepository<CheerSongQuiz, Long> {
}
