package com.baseballweb.auth.dto.quizDto;

public class CheerSongQuizDTO {
    private String songUrl;
    private String teamName;
    private String playerName;

    public CheerSongQuizDTO(String songUrl, String teamName,String playerName) {
        this.songUrl = songUrl;
        this.teamName = teamName;
        this.playerName = playerName;
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

    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
