package com.baseballweb.auth.controller;

import com.baseballweb.auth.dto.KboTeamRankingDTO;
import com.baseballweb.auth.service.KboDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/kbo")
public class KboDataController {

    private final KboDataService kboDataService;

    @Autowired
    public KboDataController(KboDataService kboDataService) {
        this.kboDataService = kboDataService;
    }

    @GetMapping("/team-rankings")
    public List<KboTeamRankingDTO> getTeamRankings() throws IOException {
        return kboDataService.getTeamRankings();
    }

    @GetMapping("/player-statistics")
    public List<String> getPlayerStatistics() throws IOException {
        return kboDataService.getPlayerStatistics();
    }
}
