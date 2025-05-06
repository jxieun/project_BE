package com.baseballweb.auth.controller;

import com.baseballweb.auth.domain.KboTeamRanking;
import com.baseballweb.auth.service.KboTeamRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class KboController {
    private final KboTeamRankingService kboTeamRankingService;

    @Autowired
    public KboController(KboTeamRankingService kboTeamRankingService) {
        this.kboTeamRankingService = kboTeamRankingService;
    }

    // 날짜별 KBO 순위 조회
    @GetMapping("/api/kbo/rankings/{date}")
    public List<KboTeamRanking> getRankings(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return kboTeamRankingService.getRankingsByDate(localDate);
    }
}
