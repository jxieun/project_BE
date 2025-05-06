package com.baseballweb.auth.controller.quizController;

import com.baseballweb.auth.dto.quizDto.CheerSongQuizDTO;
import com.baseballweb.auth.service.quizService.CheerSongQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cheer-song-quizzes")
public class CheerSongQuizController {
    @Autowired
    private CheerSongQuizService cheerSongQuizService;

    // 퀴즈 데이터 무작위로 가져오기 (특정 응원가에 대한 4개 선택지 제공)
    @GetMapping("/quiz-options")
    public List<CheerSongQuizDTO> getQuizOptions(@RequestParam Long correctQuizId) {
        return cheerSongQuizService.getQuizOptions(correctQuizId);  // 4개 선택지 반환
    }

}
