package com.baseballweb.auth.service;

import com.baseballweb.auth.dto.QuizDTO;
import com.baseballweb.auth.dto.QuizSubmissionDTO;
import com.baseballweb.auth.dto.QuizResultDTO;
import com.baseballweb.auth.repository.QuizRepository;
import com.baseballweb.auth.domain.Quiz; // Quiz 엔티티 추가
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    // 퀴즈 데이터를 삽입하는 메서드
    public Quiz insertQuizData(Quiz quiz) {
        return quizRepository.save(quiz); // JPA를 통해 퀴즈 데이터 저장
    }

    // 퀴즈 데이터 타입별로 가져오기
    public List<QuizDTO> getQuizzesByType(String type) {
        // 엔티티를 DTO로 변환
        List<Quiz> quizzes = quizRepository.findByType(type);
        return quizzes.stream()
                .map(this::convertToQuizDTO)  // Quiz 엔티티를 QuizDTO로 변환
                .collect(Collectors.toList());
    }

//    // 퀴즈 데이터 타입별로 가져오기
//    public List<Quiz> getQuizzesByType(String type) {
//        return quizRepository.findByType(type);  // `type`에 맞는 퀴즈 리스트를 가져옵니다.
//    }

    // 퀴즈 정답 평가 및 점수 계산
    public QuizResultDTO evaluateQuiz(QuizSubmissionDTO submission) {
        // 퀴즈 ID로 퀴즈 데이터를 조회하여 정답을 가져옵니다.
        Quiz quiz = quizRepository.findById(submission.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        // 제출된 답안과 정답 비교
        boolean isCorrect = checkAnswer(submission.getAnswer(), quiz.getAnswer());
        int score = isCorrect ? 10 : 0; // 맞으면 10점, 아니면 0점

        // QuizResultDTO에 정답과 제출된 답안도 함께 반환
        return new QuizResultDTO(isCorrect, score, quiz.getAnswer(), submission.getAnswer());
    }

    private boolean checkAnswer(String answer, String correctAnswer) {
        // 사용자 입력 값에서 앞뒤 공백을 제거한 후 대소문자 구분 없이 비교
        return answer != null && answer.trim().equalsIgnoreCase(correctAnswer.trim());
    }

    // Quiz 엔티티를 QuizDTO로 변환하는 메소드
    private QuizDTO convertToQuizDTO(Quiz quiz) {
        return new QuizDTO(quiz.getId(), quiz.getQuestion(), quiz.getAnswer(), quiz.getOptions(), quiz.getImage());
    }
}