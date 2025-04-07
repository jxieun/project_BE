package com.baseballweb.auth.controller;

import com.baseballweb.auth.dto.ScoreDTO;
import com.baseballweb.auth.model.Score;
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

    // 점수 제출 API
    @PostMapping("/submit")
    public ResponseEntity<ScoreDTO> submitScore(@RequestBody ScoreDTO scoreDTO) {
        ScoreDTO updatedScore = scoreService.addScore(scoreDTO);
        return ResponseEntity.ok(updatedScore);
    }

    // 팬 랭킹 조회 API
    @GetMapping("/ranking")
    public ResponseEntity<List<Score>> getTopFans() {
        List<Score> topFans = scoreService.getTopFans();
        return ResponseEntity.ok(topFans);
    }
}