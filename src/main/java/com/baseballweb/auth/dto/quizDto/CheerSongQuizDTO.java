package com.baseballweb.auth.dto.quizDto;

public class CheerSongQuizDTO {
    private String songUrl;
    private String teamName;

    // 생성자
    public CheerSongQuizDTO(String songUrl, String teamName) {
        this.songUrl = songUrl;
        this.teamName = teamName;
    }

    // Getters and Setters
    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
