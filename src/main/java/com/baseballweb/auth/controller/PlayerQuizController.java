package com.baseballweb.auth.controller;

import com.baseballweb.auth.dto.QuizResultDTO;
import com.baseballweb.auth.dto.QuizSubmissionDTO;
import com.baseballweb.auth.dto.quiz.PlayerQuizDTO;
import com.baseballweb.auth.service.quiz.PlayerQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player-quizzes")
public class PlayerQuizController {
    @Autowired
    private PlayerQuizService playerQuizService;

    // 퀴즈 데이터 무작위로 가져오기 (특정 인물에 대한 4개 선택지 제공)
    @GetMapping("/quiz-options")
    public List<PlayerQuizDTO> getQuizOptions(@RequestParam Long correctPlayerId) {
        return playerQuizService.getQuizOptions(correctPlayerId);  // 4개 선택지 반환
    }

}
