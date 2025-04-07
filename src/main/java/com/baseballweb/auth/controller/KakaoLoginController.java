package com.baseballweb.auth.controller;

import com.baseballweb.auth.dto.KakaoUserInfoResponseDto;
import com.baseballweb.auth.service.KakaoService;
import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class KakaoLoginController {

    private final KakaoService kakaoService;

    @GetMapping("/kakao")
    public ResponseEntity<?> kakao(@RequestParam("code") String code) throws IOException {
        String accessToken = kakaoService.getAccessTokenFromKakao(code);

        KakaoUserInfoResponseDto userInfo = kakaoService.getUserInfo(accessToken);
        // 여기에 서버 사용자 로그인(인증) 또는 회원가입 로직 추가
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
