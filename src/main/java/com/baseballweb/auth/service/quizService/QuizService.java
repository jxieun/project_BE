package com.baseballweb.auth.service.quizService;

import com.baseballweb.auth.domain.quizDomain.PlayerQuiz;
import com.baseballweb.auth.dto.quizresultDto.QuizSubmissionDTO;
import com.baseballweb.auth.dto.quizresultDto.QuizResultDTO;
import com.baseballweb.auth.dto.quizresultDto.ScoreDTO;
import com.baseballweb.auth.repository.quizRepository.PlayerQuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {

    @Autowired
    private PlayerQuizRepository playerQuizRepository;
    @Autowired
    private ScoreService scoreService;

    // 퀴즈 정답 평가 및 점수 계산
    public QuizResultDTO evaluateQuiz(QuizSubmissionDTO submission) {
        // 퀴즈 ID로 퀴즈 데이터를 조회하여 정답을 가져옴
        PlayerQuiz playerQuiz = playerQuizRepository.findById(submission.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // 제출된 답안과 정답 비교
        boolean isCorrect = playerQuiz.getName().equalsIgnoreCase(submission.getAnswer());
        int score = isCorrect ? 10 : 0; // 맞으면 10점, 아니면 0점

        // 점수 저장
        ScoreDTO scoreDTO = new ScoreDTO(submission.getUserId(), submission.getQuizId(), score);
        scoreService.addScore(scoreDTO);

        // QuizResultDTO 반환
        return new QuizResultDTO(isCorrect, score, playerQuiz.getName(), submission.getAnswer());
    }


}