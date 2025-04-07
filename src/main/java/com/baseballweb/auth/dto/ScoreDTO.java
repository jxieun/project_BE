package com.baseballweb.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ScoreDTO {
    private Long userId;   // 사용자 ID
    private Long quizId;   // 퀴즈 ID
    private int score;     // 점수
}