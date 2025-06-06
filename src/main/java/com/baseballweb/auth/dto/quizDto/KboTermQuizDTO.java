package com.baseballweb.auth.dto.quizDto;

public class KboTermQuizDTO {
    private String term;
    private String isCorrect;

    public KboTermQuizDTO(String term, String isCorrect) {
        this.term = term;
        this.isCorrect = isCorrect;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getIsCorrect() {
        return isCorrect;
    }
    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }
}
