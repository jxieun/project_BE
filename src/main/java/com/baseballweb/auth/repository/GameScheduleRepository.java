package com.baseballweb.auth.repository;

import com.baseballweb.auth.domain.GameSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameScheduleRepository extends JpaRepository<GameSchedule, Long> {
    // 추가적인 쿼리 메서드
}