package com.baseballweb.auth.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserPreference {
    @Id
    private Long id;
    private String teamName;
    private String playerName;
    private String themeColor; // 시그니처 컬러


//    // 기본 생성자 (JPA 필수)
//    public UserPreference() {
//    }
//
//    // 파라미터화된 생성자
//    public UserPreference(Long id, String teamName, String playerName, String themeColor) {
//        this.id = id;
//        this.teamName = teamName;
//        this.playerName = playerName;
//        this.themeColor = themeColor;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
