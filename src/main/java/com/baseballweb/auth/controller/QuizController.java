package com.baseballweb.auth.controller;

import com.baseballweb.auth.dto.QuizDTO;
import com.baseballweb.auth.dto.QuizSubmissionDTO;
import com.baseballweb.auth.dto.QuizResultDTO;
import com.baseballweb.auth.domain.Quiz;
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
        // `QuizService`에서 유형에 맞는 퀴즈를 가져옴
        List<QuizDTO> quizzes = quizService.getQuizzesByType(type);
        return ResponseEntity.ok(quizzes); // 결과 반환
    }

    // 퀴즈 제출 (정답 체크 및 점수 계산)
    @PostMapping("/submit")
    public ResponseEntity<QuizResultDTO> submitQuiz(@RequestBody QuizSubmissionDTO submission) {
        // `QuizService`에서 퀴즈 제출 평가 및 점수 계산
        QuizResultDTO result = quizService.evaluateQuiz(submission);
        return ResponseEntity.ok(result); // 결과 반환
    }

    // 퀴즈 데이터를 삽입하는 API
    @PostMapping("/add")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        Quiz savedQuiz = quizService.insertQuizData(quiz); // 데이터를 삽입
        return ResponseEntity.ok(savedQuiz);
    }

    //퀴즈 데이터를 반환하는 API
    @GetMapping("/player")
    public ResponseEntity<List<QuizDTO>> getPlayerQuizzes() {
        List<QuizDTO> quizzes = quizService.getQuizzesByType("player");
        return ResponseEntity.ok(quizzes);
    }


}