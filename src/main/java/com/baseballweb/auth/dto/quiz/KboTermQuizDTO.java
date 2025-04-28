package com.baseballweb.auth.dto.quiz;

public class KboTermQuizDTO {
    private String term;
    private boolean isCorrect;

    // 생성자
    public KboTermQuizDTO(String term, boolean isCorrect) {
        this.term = term;
        this.isCorrect = isCorrect;
    }

    // Getters and Setters
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
