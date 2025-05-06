package com.baseballweb.auth.dto;

public class UserPreferenceDTO {
    private String teamName;
    private String playerName;
    private String themeColor;

    // 기본 생성자
    public UserPreferenceDTO() {
    }

    // 파라미터화된 생성자
    public UserPreferenceDTO(String teamName, String playerName, String themeColor) {
        this.teamName = teamName;
        this.playerName = playerName;
        this.themeColor = themeColor;
    }

    // Getter 및 Setter
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }
}
