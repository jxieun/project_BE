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
            if (quizRepository.count() == 0) {
                // 기본 퀴즈 데이터 삽입
                Quiz quiz1 = new Quiz(null, "example", "이 선수의 이름은?", "홍길동", "홍길동, 이순신, 김유신", "http://localhost:8080/images/park.png");
                Quiz quiz2 = new Quiz(null, "example", "이 선수의 등번호는?", "52", "18, 23, 25, 35, 52", "http://localhost:8080/images/park.png");

                quizRepository.save(quiz1);
                quizRepository.save(quiz2);
            }

        };
    }
}
