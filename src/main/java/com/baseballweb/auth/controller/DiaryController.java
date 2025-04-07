package com.baseballweb.auth.controller;

import com.baseballweb.auth.model.Diary;
import com.baseballweb.auth.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/diary")
public class DiaryController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    // 일기 추가
    @PostMapping("/add")
    public Diary addDiary(@RequestParam String gameDate, @RequestParam String opponentTeam,
                          @RequestParam String diaryContent) {

        // 공백 제거 후 LocalDate로 변환
        gameDate = gameDate.trim();  // 공백 제거
        // gameDate를 LocalDate로 변환
        LocalDate gameDateParsed = LocalDate.parse(gameDate);  // String을 LocalDate로 변환

        // 일기 객체 생성
        Diary diary = new Diary(gameDateParsed, opponentTeam, diaryContent);

        // DiaryService를 통해 DB에 저장
        return diaryService.saveDiary(diary);
    }

    // 특정 날짜에 작성된 경기 일기 조회
    @GetMapping("/date/{gameDate}")
    public List<Diary> getDiariesByDate(@PathVariable String gameDate) {
        LocalDate gameDateParsed = LocalDate.parse(gameDate);  // gameDate를 LocalDate로 변환
        return diaryService.getDiariesByDate(gameDateParsed);  // DB에서 해당 날짜의 일기 조회
    }
}