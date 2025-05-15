package com.baseballweb.auth.repository;

import com.baseballweb.auth.domain.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatisticsRepository extends JpaRepository<PlayerStatistics, Long> {
    // 추가적으로 필요한 쿼리 정의
}
