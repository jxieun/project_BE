
package com.baseballweb.auth.service.joinService;

import com.baseballweb.auth.domain.User;
import com.baseballweb.auth.dto.joinDto.LoginRequest;
import com.baseballweb.auth.dto.joinDto.SignupRequest;
import com.baseballweb.auth.jwt.JwtUtil;
import com.baseballweb.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//핵심 비즈니스 로직 구현
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;


    public String signup(SignupRequest req) {
        // 비밀번호 확인이 일치하는지 체크
        if (!req.getPassword().equals(req.getPasswordConfirmation())) {
            return "비밀번호 확인이 일치하지 않습니다.";
        }

        // 비밀번호를 암호화하여 저장
        User user = User.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .build();

        // 사용자 저장
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
