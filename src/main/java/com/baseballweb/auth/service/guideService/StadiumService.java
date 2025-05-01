package com.baseballweb.auth.service.guideService;

import com.baseballweb.auth.domain.guideDomain.Stadium;
import org.springframework.stereotype.Service;
import com.baseballweb.auth.repository.guideRepository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;

    @Autowired
    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    // 구장 정보 조회 (교통 및 먹거리 포함)
    public Stadium getStadiumDetails(Long stadiumId) {
        return stadiumRepository.findById(stadiumId)
                .orElseThrow(() -> new RuntimeException("Stadium not found"));
    }
}

