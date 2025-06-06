package com.baseballweb.auth.controller;

import com.baseballweb.auth.domain.Player;
import com.baseballweb.auth.domain.Team;
import com.baseballweb.auth.service.PlayerService;
import com.baseballweb.auth.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.findAll();
    }
}

