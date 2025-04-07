package com.baseballweb.auth.service;

import com.baseballweb.auth.dto.ScoreDTO;
import com.baseballweb.auth.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;

    // 점수 추가
    public ScoreDTO addScore(ScoreDTO scoreDTO) {
        // 점수 추가 및 계산 로직
        scoreRepository.save(scoreDTO);
        return scoreDTO;
    }

    // 팬 랭킹 가져오기
    public List<FanDTO> getTopFans() {
        // 팬 랭킹 계산 로직
    }
}