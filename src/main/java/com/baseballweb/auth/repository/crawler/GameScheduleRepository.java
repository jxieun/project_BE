package com.baseballweb.auth.repository.crawler;

import com.baseballweb.auth.domain.crawler.GameSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameScheduleRepository extends JpaRepository<GameSchedule, Long> {
    List<GameSchedule> findBySeasonAndMonth(String season, String month);
}
