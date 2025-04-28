package com.baseballweb.auth.service;

import com.baseballweb.auth.domain.PlayerQuiz;
import com.baseballweb.auth.dto.QuizSubmissionDTO;
import com.baseballweb.auth.dto.QuizResultDTO;
import com.baseballweb.auth.repository.PlayerQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {

    @Autowired
    private PlayerQuizRepository playerQuizRepository;

    // 퀴즈 정답 평가 및 점수 계산
    public QuizResultDTO evaluateQuiz(Long quizId, String selectedAnswer) {
        // 퀴즈 ID로 퀴즈 데이터를 조회하여 정답을 가져옵니다.
        PlayerQuiz playerQuiz = playerQuizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // 제출된 답안과 정답 비교
        boolean isCorrect = playerQuiz.getName().equalsIgnoreCase(selectedAnswer);
        int score = isCorrect ? 10 : 0; // 맞으면 10점, 아니면 0점

        // QuizResultDTO에 정답과 제출된 답안도 함께 반환
        return new QuizResultDTO(isCorrect, score, playerQuiz.getName(), selectedAnswer);
    }

}