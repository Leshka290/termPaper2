package com.example.termpaper2.service;

import com.example.termpaper2.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
