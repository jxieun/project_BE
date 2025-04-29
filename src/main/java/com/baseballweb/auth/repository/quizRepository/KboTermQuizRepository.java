package com.baseballweb.auth.repository.quizRepository;

import com.baseballweb.auth.domain.quizDomain.KboTermQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KboTermQuizRepository extends JpaRepository<KboTermQuiz, Long> {
}
