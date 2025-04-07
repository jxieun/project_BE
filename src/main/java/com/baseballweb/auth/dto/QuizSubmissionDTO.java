package com.baseballweb.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizSubmissionDTO {
    private Long quizId;        // 퀴즈의 고유 ID
    private String answer;      // 사용자가 제출한 답안
    private String correctAnswer; // 정답

    public QuizSubmissionDTO() {
        // 기본 생성자 (필요에 따라 수정)
    }

    public QuizSubmissionDTO(Long quizId, String answer, String correctAnswer) {
        this.quizId = quizId;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }
}