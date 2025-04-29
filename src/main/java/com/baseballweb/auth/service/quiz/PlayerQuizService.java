package com.baseballweb.auth.service.quiz;

import com.baseballweb.auth.domain.PlayerQuiz;
import com.baseballweb.auth.dto.quiz.PlayerQuizDTO;
import com.baseballweb.auth.repository.PlayerQuizRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerQuizService {
    @Autowired
    private PlayerQuizRepository playerQuizRepository;

    // 인물 퀴즈 목록 가져오기
    public List<PlayerQuizDTO> getAllPlayerQuizzes() {
        List<PlayerQuiz> quizzes = playerQuizRepository.findAll();
        List<PlayerQuizDTO> dtoList = new ArrayList<>();

        for (PlayerQuiz quiz : quizzes) {
            PlayerQuizDTO dto = new PlayerQuizDTO(quiz.getId(), quiz.getName(), quiz.getImageUrl());
            dtoList.add(dto);
        }
        return dtoList;
    }

    // 인물 퀴즈 추가하기 (DTO -> 엔티티로 변환하여 저장)
    public void addPlayerQuiz(PlayerQuizDTO playerQuizDTO) {
        PlayerQuiz playerQuiz = new PlayerQuiz();
        playerQuiz.setName(playerQuizDTO.getName());
        playerQuiz.setImageUrl(playerQuizDTO.getImageUrl());

        // 엔티티를 데이터베이스에 저장
        playerQuizRepository.save(playerQuiz);
    }

    // 특정 인물 퀴즈의 선택지를 무작위로 4개 제공
    public List<PlayerQuizDTO> getQuizOptions(Long correctPlayerId) {
        // 정답을 포함한 선택지를 만들기 위해 정답을 가져옴
        PlayerQuiz correctPlayer = playerQuizRepository.findById(correctPlayerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        // 전체 선수 목록에서 무작위로 3명 선택 (정답 포함)
        List<PlayerQuiz> allPlayers = playerQuizRepository.findAll();
        Collections.shuffle(allPlayers); // 리스트를 무작위로 섞기

        // 선택지에 포함될 3명의 선수 + 정답
        List<PlayerQuiz> selectedPlayers = new ArrayList<>();
        selectedPlayers.add(correctPlayer); // 정답을 포함시킴
        selectedPlayers.addAll(allPlayers.stream().limit(3).collect(Collectors.toList())); // 나머지 3명

        // 최종적으로 4개의 선택지로 무작위 섞기
        Collections.shuffle(selectedPlayers); // 최종 선택지 무작위 섞기

        // PlayerQuizDTO로 변환하여 클라이언트에 제공할 데이터 반환
        return selectedPlayers.stream()
                .map(player -> new PlayerQuizDTO(player.getId(), player.getName(), player.getImageUrl()))
                .collect(Collectors.toList());
    }

}

// 제공되는 데이터 예시
//{
//        "quizOptions": [
//        {
//        "id": 1,
//        "name": "Lionel Messi",
//        "imageUrl": "http://example.com/messi.jpg"
//        },
//        {
//        "id": 2,
//        "name": "Cristiano Ronaldo",
//        "imageUrl": "http://example.com/ronaldo.jpg"
//        },
//        {
//        "id": 3,
//        "name": "Neymar",
//        "imageUrl": "http://example.com/neymar.jpg"
//        },
//        {
//        "id": 4,
//        "name": "Kylian Mbappé",
//        "imageUrl": "http://example.com/mbappe.jpg"
//        }
//        ],
//        "correctPlayerId": 1
//        }

// 프론트 리액트 예시
//import React, { useState, useEffect } from 'react';
//
//        const QuizComponent = () => {
//        // 상태 초기화
//        const [quizData, setQuizData] = useState(null);
//    const [selectedAnswer, setSelectedAnswer] = useState(null);
//    const [result, setResult] = useState('');
//
//// 컴포넌트가 마운트되면 서버에서 퀴즈 데이터를 가져옴
//useEffect(() => {
//// 예시: 서버에서 퀴즈 데이터를 가져오기
//fetch('/api/quiz-options')
//            .then(response => response.json())
//        .then(data => {
//    setQuizData(data);  // 서버로부터 받은 데이터 설정
//})
//        .catch(error => console.error('Error fetching quiz data:', error));
//        }, []);
//
//        // 답안 제출 함수
//        const handleSubmitAnswer = () => {
//        if (!selectedAnswer) {
//alert('Please select an answer!');
//            return;
//                    }
//
//// 선택된 답을 서버에 제출
//fetch('/api/quiz/submit', {
//    method: 'POST',
//            headers: { 'Content-Type': 'application/json' },
//    body: JSON.stringify({ selectedPlayerId: selectedAnswer })
//})
//        .then(response => response.json())
//        .then(data => {
//    // 결과 처리 (정답 여부, 점수 등)
//    setResult(data.isCorrect ? 'Correct!' : 'Incorrect!');
//})
//        .catch(error => console.error('Error submitting answer:', error));
//        };
//
//        // 로딩 중일 경우 처리
//        if (!quizData) {
//        return <div>Loading quiz...</div>;
//        }
//
//        return (
//        <div>
//<h2>Who is this player?</h2>
//            <img src={quizData.quizOptions[0].imageUrl} alt="Player" style={{ width: '200px' }} />
//<ul>
//{quizData.quizOptions.map(option => (
//                <li key={option.id}>
//                <button
//        onClick={() => setSelectedAnswer(option.id)}
//        style={{ backgroundColor: selectedAnswer === option.id ? 'lightgreen' : '' }}
//                        >
//    {option.name}
//                        </button>
//        </li>
//                ))}
//            </ul>
//            <button onClick={handleSubmitAnswer}>Submit Answer</button>
//        {result && <h3>{result}</h3>}
//        </div>
//        );
//        };
//
//export default QuizComponent;

