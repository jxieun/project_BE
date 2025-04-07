package com.baseballweb.auth.config;

import com.baseballweb.auth.model.Quiz;
import com.baseballweb.auth.repository.QuizRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(QuizRepository quizRepository) {
        return args -> {
            // 퀴즈 데이터를 삽입
            Quiz quiz1 = new Quiz(null, "인물", "이 선수의 이름은?", "홍길동", "홍길동, 이순신, 김유신");
            Quiz quiz2 = new Quiz(null, "등번호", "이 선수의 등번호는?", "10", "5, 10, 15");

            quizRepository.save(quiz1);  // 데이터베이스에 삽입
            quizRepository.save(quiz2);  // 데이터베이스에 삽입
        };
    }
}