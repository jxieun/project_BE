package com.baseballweb.auth.model;

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

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt = new java.util.Date();  // 점수 기록 시간
}