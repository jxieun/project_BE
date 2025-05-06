package com.baseballweb.auth.service;

import com.baseballweb.auth.domain.UserPreference;
import com.baseballweb.auth.repository.UserPreferenceRepository;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceService {
    private final UserPreferenceRepository userPreferenceRepository;

    public UserPreferenceService(UserPreferenceRepository userPreferenceRepository) {
        this.userPreferenceRepository = userPreferenceRepository;
    }

    // 사용자 응원 팀 및 선수 선택 저장
    public UserPreference saveUserPreference(UserPreference userPreference) {
        return userPreferenceRepository.save(userPreference);
    }

    // 사용자 응원 정보 조회
    public UserPreference getUserPreference(Long id) {
        // findById는 Optional을 반환하므로, get()을 사용하거나 isPresent()로 체크
        return userPreferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserPreference not found"));  // 예외 처리
    }
}
