package com.baseballweb.auth.controller;

import com.baseballweb.auth.dto.QuizResultDTO;
import com.baseballweb.auth.dto.QuizSubmissionDTO;
import com.baseballweb.auth.dto.ScoreDTO;
import com.baseballweb.auth.domain.Score;
import com.baseballweb.auth.service.QuizService;
import com.baseballweb.auth.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/score")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;
    private final QuizService quizService;

    // 점수 제출 API
    @PostMapping("/submit")
    public ResponseEntity<QuizResultDTO> submitQuiz(@RequestBody QuizSubmissionDTO submission) {
        // `QuizService`에서 퀴즈 제출 평가 및 점수 계산
        QuizResultDTO result = quizService.evaluateQuiz(submission);
        return ResponseEntity.ok(result); // 결과 반환
    }

    // 팬 랭킹 조회 API
    @GetMapping("/ranking")
    public ResponseEntity<List<Score>> getTopFans() {
        List<Score> topFans = scoreService.getTopFans();
        return ResponseEntity.ok(topFans);
    }
}