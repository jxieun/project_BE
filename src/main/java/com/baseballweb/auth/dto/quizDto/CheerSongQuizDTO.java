package com.baseballweb.auth.dto.quizDto;

public class CheerSongQuizDTO {
    private String songUrl;
    private String teamName;

    public CheerSongQuizDTO(String songUrl, String teamName) {
        this.songUrl = songUrl;
        this.teamName = teamName;
    }

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
