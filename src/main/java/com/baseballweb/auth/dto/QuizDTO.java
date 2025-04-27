package com.baseballweb.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
//데이터 전송 객체로, 클라이언트와 서버 간 데이터 전송을 담당
//QuizDTO는 퀴즈 데이터를 서버와 클라이언트 간에 전달

@Getter
@Setter
@AllArgsConstructor
public class QuizDTO {
    private Long id;            // 퀴즈 ID
    private String question;    // 문제 내용
    private String answer;      // 정답
    private String options;     // 선택지 (옵션이 있으면)
    private String image; // 이미지 URL 추가

}