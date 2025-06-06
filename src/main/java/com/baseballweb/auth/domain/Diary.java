package com.baseballweb.auth.domain;

import jakarta.persistence.*;

import java.time.LocalDate;  // Joda LocalDate가 아닌 Java 8 LocalDate 사용
//import org.springframework.data.annotation.Id;

@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 일기 ID

    //@Column(name = "game_date")  // game_date 컬럼을 명시적으로 매핑
    private LocalDate gameDate;  // 경기 날짜 (yyyy-MM-dd)
    //private String opponentTeam;  // 상대팀
    private String diaryContent;  // 일기 내용
    private String imageUrl;  // 이미지 URL (S3 저장 링크)

    public Diary() {
    }

    public Diary(LocalDate gameDate, String diaryContent, String imageUrl) {
        this.gameDate = gameDate;
        this.diaryContent = diaryContent;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }

    public String getDiaryContent() {
        return diaryContent;
    }

    public void setDiaryContent(String diaryContent) {
        this.diaryContent = diaryContent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
