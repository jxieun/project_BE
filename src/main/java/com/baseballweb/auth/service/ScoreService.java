package com.baseballweb.auth.service;

import com.baseballweb.auth.dto.ScoreDTO;
import com.baseballweb.auth.domain.Score;
import com.baseballweb.auth.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;

    // 점수 추가 (기존 점수에 추가하기)
    public ScoreDTO addScore(ScoreDTO scoreDTO) {
        // 사용자가 이미 푼 퀴즈에 대한 점수를 조회
        Score score = scoreRepository.findByUserIdAndQuizId(scoreDTO.getUserId(), scoreDTO.getQuizId())
                .orElse(new Score(scoreDTO.getUserId(), scoreDTO.getQuizId(), 0));

        // 점수를 기존 점수에 추가
        score.addScore(scoreDTO.getScore());

        // 점수 저장 (누적된 점수 저장)
        score = scoreRepository.save(score);

        return new ScoreDTO(score.getUserId(), score.getQuizId(), score.getScore());
    }


//    // 점수 추가
//    public ScoreDTO addScore(ScoreDTO scoreDTO) {
//        Score score = new Score();
//        score.setUserId(scoreDTO.getUserId());
//        score.setQuizId(scoreDTO.getQuizId());
//        score.setScore(scoreDTO.getScore());
//
//        score = scoreRepository.save(score);  // 데이터베이스에 점수 저장
//
//        return new ScoreDTO(score.getUserId(), score.getQuizId(), score.getScore());
//    }
//
    // 팬 랭킹 상위 10명 조회
    public List<Score> getTopFans() {
        return scoreRepository.findTop10ByOrderByScoreDesc();  // 상위 10명 점수 조회
    }
}