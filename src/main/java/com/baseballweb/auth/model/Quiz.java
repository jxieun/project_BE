package com.baseballweb.auth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;      // 퀴즈 ID

    private String type;  // 퀴즈 유형 (예: 인물, 등번호, OX 등)
    private String question; // 문제 내용
    private String answer; // 정답
    private String options; // 선택지 (옵션이 있으면)
}
