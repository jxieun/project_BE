package com.baseballweb.auth.controller;

import com.baseballweb.auth.dto.KakaoUserInfoResponseDto;
import com.baseballweb.auth.service.KakaoService;
import io.jsonwebtoken.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("")
//public class KakaoLoginController {
//
//    private final KakaoService kakaoService;
//
//    @GetMapping("/kakao")
//    public ResponseEntity<?> kakao(@RequestParam("code") String code) throws IOException {
//        String accessToken = kakaoService.getAccessTokenFromKakao(code);
//
//        KakaoUserInfoResponseDto userInfo = kakaoService.getUserInfo(accessToken);
//        // 여기에 서버 사용자 로그인(인증) 또는 회원가입 로직 추가
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//}
@Controller
@RequestMapping("/login")
public class KakaoLoginController {

    @Value("${kakao.client_id}")
    private String client_id;

    @Value("${kakao.redirect_uri}")
    private String redirect_uri;

    @GetMapping("/page")
    @ResponseBody  // JSON 응답을 반환하도록 변경
    public ResponseEntity<?> loginPage() {
        String location = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + client_id + "&redirect_uri=" + redirect_uri;
        return ResponseEntity.ok().body(Collections.singletonMap("location", location));  // {"location": "카카오 로그인 URL"}
    }
}

//http://localhost:8080/login/page