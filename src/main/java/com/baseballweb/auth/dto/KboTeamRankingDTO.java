package com.baseballweb.auth.dto;

import java.time.LocalDate;

public class KboTeamRankingDTO {
    private String teamName;
    private int rank;
    private LocalDate date;

    // 기본 생성자
    public KboTeamRankingDTO() {
    }

    public KboTeamRankingDTO(String teamName, int rank, LocalDate date) {
        this.teamName = teamName;
        this.rank = rank;
        this.date = date;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
