package com.baseballweb.auth.repository;
import com.baseballweb.auth.domain.KboTeamRanking;
import com.baseballweb.auth.domain.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.List;

public interface KboTeamRankingRepository extends JpaRepository<KboTeamRanking, Long> {
    // 날짜로 순위 조회
    List<KboTeamRanking> findByDate(LocalDate date);
}
