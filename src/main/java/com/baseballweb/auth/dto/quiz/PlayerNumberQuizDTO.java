package com.baseballweb.auth.dto.quiz;

public class PlayerNumberQuizDTO {
    private String number;
    private String imageUrl;

    // 생성자
    public PlayerNumberQuizDTO(String number, String imageUrl) {
        this.number = number;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
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
