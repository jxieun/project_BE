package com.baseballweb.auth.service;

import com.baseballweb.auth.domain.KboTeamRanking;
import com.baseballweb.auth.repository.KboTeamRankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.List;

@Service
public class KboTeamRankingService {
    private final KboTeamRankingRepository kboTeamRankingRepository;

    @Autowired
    public KboTeamRankingService(KboTeamRankingRepository kboTeamRankingRepository) {
        this.kboTeamRankingRepository = kboTeamRankingRepository;
    }

    // 순위 저장
    public KboTeamRanking saveRanking(KboTeamRanking ranking) {
        return kboTeamRankingRepository.save(ranking);
    }

    // 날짜로 순위 조회
    public List<KboTeamRanking> getRankingsByDate(LocalDate date) {
        return kboTeamRankingRepository.findByDate(date);
    }
}
