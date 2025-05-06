package com.baseballweb.auth.service;

import com.baseballweb.auth.domain.GameSchedule;
import com.baseballweb.auth.domain.KboTeamRanking;
import com.baseballweb.auth.domain.PlayerStatistics;
import com.baseballweb.auth.dto.KboTeamRankingDTO;
import com.baseballweb.auth.repository.GameScheduleRepository;
import com.baseballweb.auth.repository.KboTeamRankingRepository;
import com.baseballweb.auth.repository.PlayerStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KboDataService {

    private final KboTeamRankingRepository teamRankingRepository;
    private final PlayerStatisticsRepository playerStatisticsRepository;  // 추가
    private final GameScheduleRepository gameScheduleRepository;  // 추가

    @Autowired
    public KboDataService(KboTeamRankingRepository teamRankingRepository,
                          PlayerStatisticsRepository playerStatisticsRepository,
                          GameScheduleRepository gameScheduleRepository) {
        this.teamRankingRepository = teamRankingRepository;
        this.playerStatisticsRepository = playerStatisticsRepository;
        this.gameScheduleRepository = gameScheduleRepository;  // 추가된 주입
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


    // 경기 일정 데이터를 DB에 저장하는 메서드
    public void saveGameSchedule(List<String> schedule) {
        for (String game : schedule) {
            GameSchedule gameSchedule = new GameSchedule();
            // game 데이터를 파싱하여 경기 일정 저장
            // 예시: gameSchedule.setGameTime(parsedGameTime);
            // gameSchedule.setTeams(parsedTeams);
            gameScheduleRepository.save(gameSchedule);  // DB에 저장
        }
    }


    // KBO 선수 통계 크롤링 데이터를 저장
    public void savePlayerStatistics(List<String> playerStats) {
        for (String playerStat : playerStats) {
            PlayerStatistics playerStatistics = new PlayerStatistics();
            // playerStat 데이터를 파싱하여 선수 기록 정보 저장
            // playerStatistics.setPlayerName(parsedPlayerName);
            playerStatisticsRepository.save(playerStatistics);
        }
    }

    // 팀 순위 조회 (서비스에서 직접 반환)
    public List<KboTeamRankingDTO> getTeamRankings() {
        // KboTeamRankingRepository에서 팀 순위를 조회
        List<KboTeamRanking> rankings = teamRankingRepository.findAll();
        List<KboTeamRankingDTO> teamRankingDTOList = new ArrayList<>();

        // 팀 순위 데이터를 DTO로 변환
        for (KboTeamRanking ranking : rankings) {
            KboTeamRankingDTO dto = new KboTeamRankingDTO();
            dto.setTeamName(ranking.getTeamName());
            dto.setRank(ranking.getRank());
            dto.setDate(ranking.getDate());
            teamRankingDTOList.add(dto);
        }

        return teamRankingDTOList;
    }

    // 선수 통계 조회 (서비스에서 직접 반환)
    public List<String> getPlayerStatistics() {
        // 예시로 PlayerStatisticsRepository에서 선수 통계를 조회
        List<PlayerStatistics> playerStats = playerStatisticsRepository.findAll();
        List<String> playerStatsList = new ArrayList<>();

        for (PlayerStatistics stats : playerStats) {
            playerStatsList.add(stats.getPlayerName() + " " + stats.getBattingAvg());
        }

        return playerStatsList;
    }

}
