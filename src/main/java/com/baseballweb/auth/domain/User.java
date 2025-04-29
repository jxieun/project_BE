
package com.baseballweb.auth.domain;

import jakarta.persistence.*;
import lombok.*;

//비즈니스 도메인 객체, 주로 DB에 저장하고 관리됨

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    //private String nickname;
    //private String provider; // local or kakao
}
