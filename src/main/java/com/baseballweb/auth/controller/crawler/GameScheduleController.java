package com.baseballweb.auth.controller.crawler;

import com.baseballweb.auth.domain.crawler.GameSchedule;
import com.baseballweb.auth.dto.GameScheduleDTO;
import com.baseballweb.auth.repository.crawler.GameScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/schedule")
public class GameScheduleController {

    @Autowired
    private GameScheduleRepository repo;

    @GetMapping("/{season}/{month}")
    public List<GameScheduleDTO> getSchedule(@PathVariable String season, @PathVariable String month) {
        List<GameSchedule> schedules = repo.findBySeasonAndMonth(season, month);
        return schedules.stream()
                .map(s -> new GameScheduleDTO(
                        s.getDate(),
                        s.getStadium(),
                        s.getTime(),
                        s.getAwayTeam(),
                        s.getHomeTeam(),
                        s.getSeason(),
                        s.getMonth()
                ))
                .collect(Collectors.toList());
    }
}
