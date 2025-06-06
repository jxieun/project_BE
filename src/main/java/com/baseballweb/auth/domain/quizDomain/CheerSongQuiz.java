package com.baseballweb.auth.domain.quizDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//React에서 <iframe> 또는 YouTube API를 사용하면, YouTube 영상을 직접 플레이어처럼 삽입하여 재생
//embed/   ->//웹사이트 안에서 영상을 직접 보여주는 형식
@Entity
public class CheerSongQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String songUrl;  // 응원가 파일 URL
    private String teamName;  // 팀 이름
    private String playerName;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
