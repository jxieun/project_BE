package com.baseballweb.auth.controller;

import com.baseballweb.auth.dto.QuizResultDTO;
import com.baseballweb.auth.dto.QuizSubmissionDTO;
import com.baseballweb.auth.dto.quiz.CheerSongQuizDTO;
import com.baseballweb.auth.dto.quiz.KboTermQuizDTO;
import com.baseballweb.auth.dto.quiz.PlayerNumberQuizDTO;
import com.baseballweb.auth.dto.quiz.PlayerQuizDTO;
import com.baseballweb.auth.service.QuizService;
import com.baseballweb.auth.service.quiz.CheerSongQuizService;
import com.baseballweb.auth.service.quiz.KboTermQuizService;
import com.baseballweb.auth.service.quiz.PlayerNumberQuizService;
import com.baseballweb.auth.service.quiz.PlayerQuizService;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private PlayerQuizService playerQuizService;
    @Autowired
    private PlayerNumberQuizService playerNumberQuizService;
    @Autowired
    private KboTermQuizService kboTermQuizService;
    @Autowired
    private CheerSongQuizService cheerSongQuizService;

    @Autowired
    private QuizService quizService;

    // 인물 퀴즈 가져오기
    @GetMapping("/player")
    public List<PlayerQuizDTO> getPlayerQuizzes() {
        return playerQuizService.getAllPlayerQuizzes();
    }

    // 등번호 퀴즈 가져오기
    @GetMapping("/player/number")
    public List<PlayerNumberQuizDTO> getPlayerNumberQuizzes() {
        return playerNumberQuizService.getAllPlayerNumberQuizzes();
    }

    // 롤 용어 퀴즈 가져오기
    @GetMapping("/kbo-term")
    public List<KboTermQuizDTO> getKboTermQuizzes() {
        return kboTermQuizService.getAllKboTermQuizzes();
    }

    // 응원가 퀴즈 가져오기
    @GetMapping("/cheer-song")
    public List<CheerSongQuizDTO> getCheerSongQuizzes() {
        return cheerSongQuizService.getAllCheerSongQuizzes();
    }

    // 인물 퀴즈 추가하기
    @PostMapping("/add/player")
    public void addPlayerQuiz(@RequestBody PlayerQuizDTO playerQuizDTO) {
        playerQuizService.addPlayerQuiz(playerQuizDTO);
    }

    // KBO 용어 퀴즈 추가하기
    @PostMapping("/add/kbo-term")
    public void addKboTermQuiz(@RequestBody KboTermQuizDTO kboTermQuizDTO) {
        kboTermQuizService.addKboTermQuiz(kboTermQuizDTO);
    }

    // 응원가 퀴즈 추가하기
    @PostMapping("/add/cheer-song")
    public void addCheerSongQuiz(@RequestBody CheerSongQuizDTO cheerSongQuizDTO) {
        cheerSongQuizService.addCheerSongQuiz(cheerSongQuizDTO);
    }

    // 등번호 퀴즈 추가하기
    @PostMapping("/add/player/number")
    public void addPlayerNumberQuiz(@RequestBody PlayerNumberQuizDTO playerNumberQuizDTO) {
        playerNumberQuizService.addPlayerNumberQuiz(playerNumberQuizDTO);
    }

}