package com.baseballweb.auth.controller;

import com.baseballweb.auth.dto.QuizDTO;
import com.baseballweb.auth.dto.QuizSubmissionDTO;
import com.baseballweb.auth.dto.QuizResultDTO;
import com.baseballweb.auth.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    // 퀴즈 데이터 가져오기 (퀴즈 유형별로)
    @GetMapping("/{type}")
    public ResponseEntity<List<QuizDTO>> getQuizzes(@PathVariable String type) {
        List<QuizDTO> quizzes = quizService.getQuizzesByType(type);
        return ResponseEntity.ok(quizzes);
    }

    // 퀴즈 제출 (정답 체크 및 점수 계산)
    @PostMapping("/submit")
    public ResponseEntity<QuizResultDTO> submitQuiz(@RequestBody QuizSubmissionDTO submission) {
        QuizResultDTO result = quizService.evaluateQuiz(submission);
        return ResponseEntity.ok(result);
    }
}