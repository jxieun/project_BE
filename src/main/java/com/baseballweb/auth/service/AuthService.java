
package com.baseballweb.auth.service;

import com.baseballweb.auth.domain.User;
import com.baseballweb.auth.dto.LoginRequest;
import com.baseballweb.auth.dto.SignupRequest;
import com.baseballweb.auth.jwt.JwtUtil;
import com.baseballweb.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String signup(SignupRequest req) {
        User user = User.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .nickname(req.getNickname())
                .provider("local")
                .build();

        userRepository.save(user);
        return "회원가입 완료";
    }

    public String login(LoginRequest req) {
        User user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원"));

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 틀렸습니다");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}
