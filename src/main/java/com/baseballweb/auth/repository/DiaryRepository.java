package com.baseballweb.auth.repository;

import com.baseballweb.auth.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    // `game_date` 컬럼을 기준으로 데이터 조회
    List<Diary> findByGameDate(LocalDate gameDate);  // 특정 날짜의 경기 일기 조회
}