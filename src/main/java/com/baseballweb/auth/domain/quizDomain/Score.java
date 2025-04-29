package com.baseballweb.auth.domain.quizDomain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;      // 점수 ID (자동 증가)

    private Long userId;  // 사용자 ID (사용자와 연결)
    private Long quizId;  // 퀴즈 ID (퀴즈와 연결)
    private int score;    // 점수 (퀴즈 맞힌 점수)

    // 사용자 ID, 퀴즈 ID, 점수를 받는 생성자 추가
    public Score(Long userId, Long quizId, int score) {
        this.userId = userId;
        this.quizId = quizId;
        this.score = score;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // 기존 점수를 누적
    public void addScore(int additionalScore) {
        this.score += additionalScore;
    }

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt = new java.util.Date();  // 점수 기록 시간
}