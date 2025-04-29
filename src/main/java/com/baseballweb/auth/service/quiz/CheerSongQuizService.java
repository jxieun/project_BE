package com.baseballweb.auth.service.quiz;

import com.baseballweb.auth.domain.CheerSongQuiz;
import com.baseballweb.auth.dto.quiz.CheerSongQuizDTO;
import com.baseballweb.auth.repository.CheerSongQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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


    // 응원가 퀴즈 4개 선택지 제공 (무작위)
    public List<CheerSongQuizDTO> getQuizOptions(Long correctQuizId) {
        // 정답을 포함한 선택지를 만들기 위해 정답을 가져옴
        CheerSongQuiz correctQuiz = cheerSongQuizRepository.findById(correctQuizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // 전체 응원가 퀴즈 목록에서 무작위로 3개 선택 (정답 포함)
        List<CheerSongQuiz> allQuizzes = cheerSongQuizRepository.findAll();
        Collections.shuffle(allQuizzes); // 리스트를 무작위로 섞기

        // 3개 선택지 + 정답
        List<CheerSongQuiz> selectedQuizzes = new ArrayList<>();
        selectedQuizzes.add(correctQuiz); // 정답을 포함시킴
        selectedQuizzes.addAll(allQuizzes.stream().limit(3).collect(Collectors.toList())); // 나머지 3개

        // 최종적으로 4개 선택지로 무작위 섞기
        Collections.shuffle(selectedQuizzes); // 최종 선택지 무작위 섞기

        // CheerSongQuizDTO로 변환하여 클라이언트에 제공할 데이터 반환
        return selectedQuizzes.stream()
                .map(quiz -> new CheerSongQuizDTO(quiz.getSongUrl(), quiz.getTeamName()))
                .collect(Collectors.toList());
    }
}
