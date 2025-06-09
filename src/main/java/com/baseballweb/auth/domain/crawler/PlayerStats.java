package com.baseballweb.auth.domain.crawler;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PlayerStats {
    @Id
    @GeneratedValue
    private Long id;

    private String playerName;
    private String team;
    private String season;
    private String position;
    private Float avg;
    private Integer hr;
    private Integer rbi;
}