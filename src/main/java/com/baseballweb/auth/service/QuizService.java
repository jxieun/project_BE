package com.baseballweb.auth.service;

import com.baseballweb.auth.dto.QuizDTO;
import com.baseballweb.auth.dto.QuizSubmissionDTO;
import com.baseballweb.auth.dto.QuizResultDTO;
import com.baseballweb.auth.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    // 퀴즈 데이터 타입별로 가져오기
    public List<QuizDTO> getQuizzesByType(String type) {
        return quizRepository.findByType(type);
    }

    // 퀴즈 정답 평가 및 점수 계산
    public QuizResultDTO evaluateQuiz(QuizSubmissionDTO submission) {
        // 제출된 답안과 정답 비교
        boolean isCorrect = checkAnswer(submission);
        int score = isCorrect ? 10 : 0; // 예시: 맞으면 10점, 아니면 0점
        return new QuizResultDTO(isCorrect, score);
    }

    private boolean checkAnswer(QuizSubmissionDTO submission) {
        // 정답 비교 로직
        return submission.getAnswer().equalsIgnoreCase(submission.getCorrectAnswer());
    }
}