package com.baseballweb.auth.dto;

public class GameScheduleDTO {
    private String date;
    private String stadium;
    private String time;
    private String awayTeam;
    private String homeTeam;
    private String season;
    private String month;

    public GameScheduleDTO(String date, String stadium, String time, String awayTeam, String homeTeam, String season, String month) {
        this.date = date;
        this.stadium = stadium;
        this.time = time;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.season = season;
        this.month = month;
    }

    // Getter만 사용
    public String getDate() {
        return date;
    }

    public String getStadium() {
        return stadium;
    }

    public String getTime() {
        return time;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getSeason() {
        return season;
    }

    public String getMonth() {
        return month;
    }
}