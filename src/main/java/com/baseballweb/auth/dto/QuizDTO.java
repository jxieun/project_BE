package com.baseballweb.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuizDTO {
    private Long id;            // 퀴즈 ID
    private String question;    // 문제 내용
    private String answer;      // 정답
    private String options;     // 선택지 (옵션이 있으면)
}