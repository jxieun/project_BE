package com.baseballweb.auth.controller.crawler;

import com.baseballweb.auth.domain.crawler.PlayerStats;
import com.baseballweb.auth.repository.crawler.PlayerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class PlayerStatsController {

    @Autowired
    private PlayerStatsRepository repo;

    @GetMapping("/{season}/{team}/{position}")
    public List<PlayerStats> getStats(
            @PathVariable String season,
            @PathVariable String team,
            @PathVariable String position) {
        return repo.findBySeasonAndTeamAndPosition(season, team, position);
    }
}
