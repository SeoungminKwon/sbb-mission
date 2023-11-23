package com.example.sbbmission.domain.question;

import com.example.sbbmission.domain.DataNotFoundException;
import com.example.sbbmission.domain.answer.Answer;
import com.example.sbbmission.domain.answer.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional< Question > question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        }else{
            throw new DataNotFoundException("question not found");
        }
    }

}
