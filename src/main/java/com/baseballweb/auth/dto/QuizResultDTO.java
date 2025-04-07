package com.baseballweb.auth.dto;

public class QuizResultDTO {
    private boolean isCorrect;
    private int score;

    public QuizResultDTO(boolean isCorrect, int score) {
        this.isCorrect = isCorrect;
        this.score = score;
    }
}