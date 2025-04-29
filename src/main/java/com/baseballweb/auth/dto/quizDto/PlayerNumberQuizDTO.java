package com.baseballweb.auth.dto.quizDto;

public class PlayerNumberQuizDTO {
    private String number;
    private String imageUrl;

    public PlayerNumberQuizDTO(String number, String imageUrl) {
        this.number = number;
        this.imageUrl = imageUrl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
