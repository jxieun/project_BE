package com.baseballweb.auth.repository;

import com.baseballweb.auth.domain.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatisticsRepository extends JpaRepository<PlayerStatistics, Long> {
}
