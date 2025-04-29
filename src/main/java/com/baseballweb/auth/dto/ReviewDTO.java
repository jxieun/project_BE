package com.baseballweb.auth.dto;

public class ReviewDTO {
    private double rating;  // 별점
    private String content;  // 리뷰 내용
    private String imageUrl;  // 사진 URL

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
