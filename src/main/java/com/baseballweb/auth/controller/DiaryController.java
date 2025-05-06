package com.baseballweb.auth.controller;

import com.baseballweb.auth.domain.Diary;
import com.baseballweb.auth.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public Diary addDiary(@RequestParam String gameDate,
                          @RequestParam String diaryContent,
                          @RequestParam(required = false) MultipartFile image) {

        // 공백 제거 후 LocalDate로 변환
        gameDate = gameDate.trim();
        // gameDate를 LocalDate로 변환
        LocalDate gameDateParsed = LocalDate.parse(gameDate);  // String을 LocalDate로 변환

        // 일기 객체 생성
        String imageUrl = null;
        if (image != null && !image.isEmpty()) {
            imageUrl = diaryService.uploadImage(image);  // 이미지 업로드
        }

        Diary diary = new Diary(gameDateParsed, diaryContent, imageUrl);

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