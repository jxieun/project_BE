package com.baseballweb.auth.repository.crawler;

import com.baseballweb.auth.domain.crawler.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {
    List<PlayerStats> findBySeasonAndTeamAndPosition(String season, String team, String position);
}
