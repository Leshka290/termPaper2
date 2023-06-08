package com.example.termpaper2.repositories;

import com.example.termpaper2.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(String question, String answer);
    Question remove(String question);
    Collection<Question> getAll();
}
