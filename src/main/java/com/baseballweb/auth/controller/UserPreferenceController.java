package com.baseballweb.auth.controller;

import com.baseballweb.auth.domain.UserPreference;
import com.baseballweb.auth.service.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/preference")
public class UserPreferenceController {

    private final UserPreferenceService userPreferenceService;  // 필드 선언 추가


    @Autowired
    public UserPreferenceController(UserPreferenceService userPreferenceService) {
        this.userPreferenceService = userPreferenceService;
    }

    // 응원 팀 및 선수 선택 저장
    @PostMapping("/save")
    public UserPreference saveUserPreference(@RequestBody UserPreference userPreference) {
        return userPreferenceService.saveUserPreference(userPreference);
    }

    // 응원 팀 및 선수 정보 조회
    @GetMapping("/{id}")
    public UserPreference getUserPreference(@PathVariable Long id) {
        return userPreferenceService.getUserPreference(id);
    }
}
