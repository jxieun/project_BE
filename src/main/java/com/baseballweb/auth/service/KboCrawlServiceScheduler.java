package com.baseballweb.auth.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public class KboCrawlServiceScheduler {
    private final KboCrawlService kboCrawlService;

    public KboCrawlServiceScheduler(KboCrawlService kboCrawlService) {
        this.kboCrawlService = kboCrawlService;
    }

    // 매일 0시마다 순위표와 경기 일정 크롤링
    @Scheduled(cron = "0 0 0 * * ?")
    public void updateKboData() {
        try {
            List<String> rankings = kboCrawlService.getTeamRankings();
            List<String> schedule = kboCrawlService.getGameSchedule();
            // 이 데이터를 DB에 저장
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
