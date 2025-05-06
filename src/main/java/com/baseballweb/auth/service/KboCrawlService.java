package com.baseballweb.auth.service;

import com.baseballweb.auth.dto.KboTeamRankingDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class KboCrawlService {
    private final KboDataService kboDataService;

    public KboCrawlService(KboDataService kboDataService) {
        this.kboDataService = kboDataService;
    }

    @Scheduled(cron = "0 0 0 * * ?")  // 매일 자정에 실행
    public void updateKboData() {
        try {
            // KBO 순위 데이터 크롤링
            List<String> rankings = getTeamRankings();
            kboDataService.saveTeamRankings(rankings);  // DB에 저장

            // 경기 일정 데이터 크롤링
            List<String> schedule = getGameSchedule();
            kboDataService.saveGameSchedule(schedule);  // DB에 저장

            // 선수 통계 데이터 크롤링 (선택 사항)
            List<String> playerStats = getPlayerStatistics();
            kboDataService.savePlayerStatistics(playerStats);  // DB에 저장
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getTeamRankings() throws IOException {
        String url = "https://www.koreabaseball.com/TeamRank/TeamRank.aspx";
        Document doc = Jsoup.connect(url).get();

        Elements rows = doc.select("table tbody tr");
        List<String> rankings = new ArrayList<>();

        for (Element row : rows) {
            String teamName = row.select("td.team-name").text();
            String rank = row.select("td.rank").text();
            rankings.add(rank + " " + teamName);
        }

        return rankings;
    }

    public List<String> getGameSchedule() throws IOException {
        String url = "https://www.koreabaseball.com/Schedule/Schedule.aspx";
        Document doc = Jsoup.connect(url).get();

        Elements games = doc.select("table.schedule tbody tr");
        List<String> schedule = new ArrayList<>();

        for (Element game : games) {
            String gameTime = game.select("td.game-time").text();
            String teams = game.select("td.teams").text();
            schedule.add(gameTime + " " + teams);
        }

        return schedule;
    }

    public List<String> getPlayerStatistics() throws IOException {
        String url = "https://www.koreabaseball.com/Player/PlayerList.aspx";
        Document doc = Jsoup.connect(url).get();

        Elements players = doc.select("table.player-statistics tbody tr");
        List<String> playerStats = new ArrayList<>();

        for (Element player : players) {
            String playerName = player.select("td.player-name").text();
            String playerStatsText = player.select("td.stats").text();
            playerStats.add(playerName + " " + playerStatsText);
        }

        return playerStats;
    }
}