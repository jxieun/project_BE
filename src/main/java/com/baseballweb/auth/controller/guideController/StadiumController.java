package com.baseballweb.auth.controller.guideController;

import com.baseballweb.auth.domain.guideDomain.Stadium;
import com.baseballweb.auth.dto.guideDto.StadiumDTO;
import com.baseballweb.auth.service.guideService.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stadiums")
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;

    // 구장 상세 정보 조회 API (교통 및 먹거리 포함)
    @GetMapping("/{stadiumId}")
    public ResponseEntity<StadiumDTO> getStadiumDetails(@PathVariable Long stadiumId) {
        Stadium stadium = stadiumService.getStadiumDetails(stadiumId);

        // Stadium 객체를 StadiumDTO로 변환
        StadiumDTO stadiumDTO = new StadiumDTO();
        stadiumDTO.setId(stadium.getId());
        stadiumDTO.setName(stadium.getName());
        stadiumDTO.setLocation(stadium.getLocation());
        stadiumDTO.setTransportation(stadium.getTransportation());
        stadiumDTO.setFood(stadium.getFood());

        return ResponseEntity.ok(stadiumDTO);
    }
}
