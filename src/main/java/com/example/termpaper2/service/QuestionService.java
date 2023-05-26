package com.example.termpaper2.service;

import com.example.termpaper2.model.Question;

import java.util.Collection;
import java.util.Set;

public interface QuestionService {

    Question add(String question, String answer);
//    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
//    Question getRandomQuestion();
}
