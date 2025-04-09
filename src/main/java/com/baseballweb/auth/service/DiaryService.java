package com.baseballweb.auth.service;

import com.baseballweb.auth.model.Diary;
import com.baseballweb.auth.repository.DiaryRepository;
//import io.jsonwebtoken.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final S3Service s3Service;  // S3Service 의존성 주입

    @Autowired
    public DiaryService(DiaryRepository diaryRepository,  S3Service s3Service) {
        this.diaryRepository = diaryRepository;
        this.s3Service = s3Service;
    }

    // 경기 일기 저장
    public Diary saveDiary(Diary diary) {
        return diaryRepository.save(diary);  // 일기를 DB에 저장
    }

    // 특정 날짜에 작성된 경기 일기 조회
    public List<Diary> getDiariesByDate(LocalDate gameDate) {
        return diaryRepository.findByGameDate(gameDate);  // DB에서 해당 날짜의 일기 조회
    }

    // 이미지 업로드 처리
    public String uploadImage(MultipartFile image) {
        try {
            return s3Service.uploadFile(image);  // S3에 이미지 업로드
        } catch (IOException e) {
            e.printStackTrace();
            return null;  // 실패시 null 반환
        }
    }
}
