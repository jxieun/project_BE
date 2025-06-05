package com.baseballweb.auth.dto;

public class HitterStatsDTO {
    private String playerName;
    private String team;
    private String season;
    private Float avg;
    private Integer hr;
    private Integer rbi;

    public HitterStatsDTO(String playerName, String team, String season, Float avg, Integer hr, Integer rbi) {
        this.playerName = playerName;
        this.team = team;
        this.season = season;
        this.avg = avg;
        this.hr = hr;
        this.rbi = rbi;
    }

    public String getPlayerName() { return playerName; }
    public String getTeam() { return team; }
    public String getSeason() { return season; }
    public Float getAvg() { return avg; }
    public Integer getHr() { return hr; }
    public Integer getRbi() { return rbi; }
}
