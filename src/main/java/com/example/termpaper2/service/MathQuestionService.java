package com.example.termpaper2.service;

import com.example.termpaper2.model.Question;
import com.example.termpaper2.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MathQuestionService implements QuestionService{

    QuestionRepository questionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    @Override
    public Question add(String question, String answer) {
        return questionRepository.add(question, answer);
    }

    @Override
    public Question remove(String question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }
}
