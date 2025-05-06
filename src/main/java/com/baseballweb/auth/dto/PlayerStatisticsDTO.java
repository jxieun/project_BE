package com.baseballweb.auth.dto;

public class PlayerStatisticsDTO {
    private String playerName;
    private String teamName;
    private String position;
    private double battingAvg;

    // 기본 생성자
    public PlayerStatisticsDTO() {
    }

    // 파라미터화된 생성자
    public PlayerStatisticsDTO(String playerName, String teamName, String position, double battingAvg) {
        this.playerName = playerName;
        this.teamName = teamName;
        this.position = position;
        this.battingAvg = battingAvg;
    }

    // Getter 및 Setter
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getBattingAvg() {
        return battingAvg;
    }

    public void setBattingAvg(double battingAvg) {
        this.battingAvg = battingAvg;
    }
}
