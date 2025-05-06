package com.baseballweb.auth.service;

import com.baseballweb.auth.domain.KboTeamRanking;
import com.baseballweb.auth.repository.KboTeamRankingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KboDataService {

    private final KboTeamRankingRepository teamRankingRepository;

    public KboDataService(KboTeamRankingRepository teamRankingRepository) {
        this.teamRankingRepository = teamRankingRepository;
    }

    public void saveTeamRankings(List<String> rankings) {
        for (String ranking : rankings) {
            KboTeamRanking teamRanking = new KboTeamRanking();
            // ranking 데이터를 파싱하여 팀 순위 정보 저장
            // 예시: teamRanking.setTeamName(parsedTeamName);
            // teamRanking.setRank(parsedRank);
            // teamRanking.setDate(LocalDate.now()); // 예시로 현재 날짜 설정
            teamRankingRepository.save(teamRanking);
        }
    }

    public void savePlayerStatistics(List<String> playerStats) {
        // 선수 통계 저장 로직
    }
}
