package com.baseballweb.auth.controller.crawler;

import com.baseballweb.auth.domain.crawler.HitterStats;
import com.baseballweb.auth.dto.HitterStatsDTO;
import com.baseballweb.auth.repository.crawler.HitterStatsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hitter")
public class HitterStatsController {

    private final HitterStatsRepository repo;

    public HitterStatsController(HitterStatsRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{season}/{team}")
    public List<HitterStatsDTO> getStats(@PathVariable String season, @PathVariable String team) {
        List<HitterStats> statsList = repo.findBySeasonAndTeam(season, team);

        // 변환
        return statsList.stream()
                .map(stat -> new HitterStatsDTO(
                        stat.getPlayerName(),
                        stat.getTeam(),
                        stat.getSeason(),
                        stat.getAvg(),
                        stat.getHr(),
                        stat.getRbi()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public HitterStats saveHitter(@RequestBody HitterStatsDTO dto) {
        HitterStats entity = new HitterStats();
        entity.setPlayerName(dto.getPlayerName());
        entity.setTeam(dto.getTeam());
        entity.setSeason(dto.getSeason());
        entity.setAvg(dto.getAvg());
        entity.setHr(dto.getHr());
        entity.setRbi(dto.getRbi());
        return repo.save(entity);
    }
}
