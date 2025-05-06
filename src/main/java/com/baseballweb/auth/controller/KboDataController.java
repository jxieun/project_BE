package com.baseballweb.auth.controller;

import com.baseballweb.auth.dto.KboTeamRankingDTO;
import com.baseballweb.auth.service.KboDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/kbo")
public class KboDataController {

    private final KboDataService kboDataService;

    @Autowired
    public KboDataController(KboDataService kboDataService) {
        this.kboDataService = kboDataService;
    }

    // 현재 KBO 순위표
    @GetMapping("/team-rankings")
    public List<KboTeamRankingDTO> getTeamRankings() throws IOException {
        return kboDataService.getTeamRankings();
    }


    // 현재 KBO 선수 통계
    @GetMapping("/player-statistics")
    public List<String> getPlayerStatistics() throws IOException {
        return kboDataService.getPlayerStatistics();
    }


}
