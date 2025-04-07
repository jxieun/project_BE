package com.baseballweb.auth.service;

import com.baseballweb.auth.model.Diary;
import com.baseballweb.auth.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    // 경기 일기 저장
    public Diary saveDiary(Diary diary) {
        return diaryRepository.save(diary);  // 일기를 DB에 저장
    }

    // 특정 날짜에 작성된 경기 일기 조회
    public List<Diary> getDiariesByDate(LocalDate gameDate) {
        return diaryRepository.findByGameDate(gameDate);  // DB에서 해당 날짜의 일기 조회
    }
}