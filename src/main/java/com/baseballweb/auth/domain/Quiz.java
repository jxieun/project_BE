package com.baseballweb.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//JPA 엔티티로, 데이터베이스의 quiz 테이블과 매핑되어 퀴즈 정보를 저장하고 관리

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
    private String image; // 이미지 URL 추가
}
