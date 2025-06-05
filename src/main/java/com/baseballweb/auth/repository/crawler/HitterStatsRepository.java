package com.baseballweb.auth.repository.crawler;

import com.baseballweb.auth.domain.crawler.HitterStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HitterStatsRepository extends JpaRepository<HitterStats, Long> {
    List<HitterStats> findBySeasonAndTeam(String season, String team);
}

