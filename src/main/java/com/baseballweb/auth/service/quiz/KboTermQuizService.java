package com.baseballweb.auth.service.quiz;

import com.baseballweb.auth.domain.KboTermQuiz;
import com.baseballweb.auth.dto.quiz.KboTermQuizDTO;
import com.baseballweb.auth.repository.KboTermQuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KboTermQuizService {
    @Autowired
    private KboTermQuizRepository kboTermQuizRepository;

    // KBO 용어 퀴즈 목록 가져오기 (DTO 반환)
    public List<KboTermQuizDTO> getAllKboTermQuizzes() {
        List<KboTermQuiz> quizzes = kboTermQuizRepository.findAll();
        List<KboTermQuizDTO> dtoList = new ArrayList<>();

        // 엔티티를 DTO로 변환
        for (KboTermQuiz quiz : quizzes) {
            KboTermQuizDTO dto = new KboTermQuizDTO(quiz.getTerm(), quiz.isCorrect());
            dtoList.add(dto);
        }

        return dtoList;
    }

    // 특정 KBO 용어 퀴즈 추가하기 (DTO -> 엔티티로 변환하여 저장)
    public void addKboTermQuiz(KboTermQuizDTO kboTermQuizDTO) {
        KboTermQuiz kboTermQuiz = new KboTermQuiz();
        kboTermQuiz.setTerm(kboTermQuizDTO.getTerm());
        kboTermQuiz.setCorrect(kboTermQuizDTO.isCorrect());

        // 엔티티를 데이터베이스에 저장
        kboTermQuizRepository.save(kboTermQuiz);
    }
}
