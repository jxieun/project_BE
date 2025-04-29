package com.baseballweb.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizSubmissionDTO {
//    private Long quizId;        // 퀴즈의 고유 ID
//    private String answer;      // 사용자가 제출한 답안
//    private String correctAnswer; // 정답

    private Long quizId;        // 퀴즈의 고유 ID
    private String answer;      // 사용자가 제출한 답안
    private Long userId;        // 사용자의 ID (점수를 저장하기 위해 필요)


    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}