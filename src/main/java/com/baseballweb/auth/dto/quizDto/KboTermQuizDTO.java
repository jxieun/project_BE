package com.baseballweb.auth.dto.quizDto;

public class KboTermQuizDTO {
    private String term;
    private boolean isCorrect;

    public KboTermQuizDTO(String term, boolean isCorrect) {
        this.term = term;
        this.isCorrect = isCorrect;
    }

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
