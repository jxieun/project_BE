package com.baseballweb.auth.domain;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 리뷰 ID

    private int rating;  // 별점
    private String content;  // 리뷰 내용
    private String imageUrl;  // 사진 URL

    @ManyToOne
    @JoinColumn(name = "stadium_id", nullable = false) // 구장과 연결 (stadium_id를 외래키로 설정)
    private Stadium stadium;  // 구장과 연결

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
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

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
}
