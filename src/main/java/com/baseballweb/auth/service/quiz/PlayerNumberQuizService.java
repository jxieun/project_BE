package com.baseballweb.auth.service.quiz;

import com.baseballweb.auth.domain.PlayerNumberQuiz;
import com.baseballweb.auth.dto.quiz.PlayerNumberQuizDTO;
import com.baseballweb.auth.repository.PlayerNumberQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerNumberQuizService {
    @Autowired
    private PlayerNumberQuizRepository playerNumberQuizRepository;

    // 등번호 퀴즈 목록 가져오기 (DTO 반환)
    public List<PlayerNumberQuizDTO> getAllPlayerNumberQuizzes() {
        List<PlayerNumberQuiz> quizzes = playerNumberQuizRepository.findAll();
        List<PlayerNumberQuizDTO> dtoList = new ArrayList<>();

        // 엔티티를 DTO로 변환
        for (PlayerNumberQuiz quiz : quizzes) {
            PlayerNumberQuizDTO dto = new PlayerNumberQuizDTO(quiz.getNumber(), quiz.getImageUrl());
            dtoList.add(dto);
        }

        return dtoList;
    }

    // 특정 등번호 퀴즈 추가하기 (DTO -> 엔티티로 변환하여 저장)
    public void addPlayerNumberQuiz(PlayerNumberQuizDTO playerNumberQuizDTO) {
        PlayerNumberQuiz playerNumberQuiz = new PlayerNumberQuiz();
        playerNumberQuiz.setNumber(playerNumberQuizDTO.getNumber());
        playerNumberQuiz.setImageUrl(playerNumberQuizDTO.getImageUrl());

        // 엔티티를 데이터베이스에 저장
        playerNumberQuizRepository.save(playerNumberQuiz);
    }
}
