package com.baseballweb.auth.service.quiz;

import com.baseballweb.auth.domain.CheerSongQuiz;
import com.baseballweb.auth.dto.quiz.CheerSongQuizDTO;
import com.baseballweb.auth.repository.CheerSongQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheerSongQuizService {
    @Autowired
    private CheerSongQuizRepository cheerSongQuizRepository;

    // 응원가 퀴즈 목록 가져오기 (DTO 반환)
    public List<CheerSongQuizDTO> getAllCheerSongQuizzes() {
        List<CheerSongQuiz> quizzes = cheerSongQuizRepository.findAll();
        List<CheerSongQuizDTO> dtoList = new ArrayList<>();

        // 엔티티를 DTO로 변환
        for (CheerSongQuiz quiz : quizzes) {
            CheerSongQuizDTO dto = new CheerSongQuizDTO(quiz.getSongUrl(), quiz.getTeamName());
            dtoList.add(dto);
        }

        return dtoList;
    }

    // 특정 응원가 퀴즈 추가하기 (DTO -> 엔티티로 변환하여 저장)
    public void addCheerSongQuiz(CheerSongQuizDTO cheerSongQuizDTO) {
        CheerSongQuiz cheerSongQuiz = new CheerSongQuiz();
        cheerSongQuiz.setSongUrl(cheerSongQuizDTO.getSongUrl());
        cheerSongQuiz.setTeamName(cheerSongQuizDTO.getTeamName());

        // 엔티티를 데이터베이스에 저장
        cheerSongQuizRepository.save(cheerSongQuiz);
    }
}
