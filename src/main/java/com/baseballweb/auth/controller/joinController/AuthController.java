
package com.baseballweb.auth.controller.joinController;

import com.baseballweb.auth.dto.joinDto.LoginRequest;
import com.baseballweb.auth.dto.joinDto.SignupRequest;
import com.baseballweb.auth.service.joinService.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 웹MVC의 컨트롤러 역할
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
