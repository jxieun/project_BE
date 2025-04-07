package com.baseballweb.auth.dto;

public class QuizResultDTO {
    private boolean isCorrect;  // 정답 여부
    private int score;  // 점수
    private String correctAnswer;  // 정답
    private String submittedAnswer;  // 제출된 답안

    public QuizResultDTO(boolean isCorrect, int score, String correctAnswer, String submittedAnswer) {
        this.isCorrect = isCorrect;
        this.score = score;
        this.correctAnswer = correctAnswer;
        this.submittedAnswer = submittedAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    public void setSubmittedAnswer(String submittedAnswer) {
        this.submittedAnswer = submittedAnswer;
    }
}